package com.team404.visualwith.service;

import com.team404.visualwith.dto.todo.*;
import com.team404.visualwith.entity.Todo;
import com.team404.visualwith.entity.UserTeamRole;
import com.team404.visualwith.repository.TodoRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TodoService {
    private final TodoRepository todoRepository;

    public TodoService(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    // 할 일 생성
    public TodoAddResponse createTodo(TodoAddRequest todoAddRequest, String userId) {
        Todo todo = new Todo(todoAddRequest, userId);
        todoRepository.save(todo);
        return new TodoAddResponse(todo.getId());
    }

    // 할 일 목록 조회
    public List<TodoGetResponse> getTodo(String teamId) {
        List<Todo> todoList = todoRepository.findByTeamId(teamId);
        List<TodoGetResponse> dtoList = new ArrayList<>();
        for(Todo todo : todoList) {
            dtoList.add(new TodoGetResponse(todo));
        }
        return dtoList;
    }

    // 할 일 수정
    public void updateTodo(TodoUpdateRequest todoUpdateRequest, String userId) {
        Todo todo = todoRepository.findById(todoUpdateRequest.getId())
                .orElseThrow(() -> new RuntimeException("Todo 없음"));
        if(!(userId.equals(todo.getCreatorId()))
                || todoUpdateRequest.getUserTeamRole() != UserTeamRole.MEMBER) {
            throw new RuntimeException("권한이 없습니다.");
        }
        todo.update(todoUpdateRequest);
        todoRepository.save(todo);
    }

    public void completeTodo(TodoCompleteRequest todoCompleteRequest, String userId) {
        Todo todo = todoRepository.findById(todoCompleteRequest.getId())
                .orElseThrow(() -> new RuntimeException("Todo 없음"));
        if(!(userId.equals(todo.getCreatorId()))
                || todoCompleteRequest.getUserTeamRole() != UserTeamRole.MEMBER) {
            throw new RuntimeException("권한이 없습니다.");
        }
        todo.complete(todoCompleteRequest);
        todoRepository.save(todo);
    }

    public void deleteTodo(TodoDeleteRequest todoDeleteRequest){
        Todo todo = todoRepository.findById(todoDeleteRequest.getId())
                .orElseThrow(() -> new RuntimeException("Todo 없음"));
        if(!(todoDeleteRequest.getUserId().equals(todo.getCreatorId())
                || todoDeleteRequest.getUserTeamRole() == UserTeamRole.SUB_ADMIN
                || todoDeleteRequest.getUserTeamRole() == UserTeamRole.ADMIN)) {
            throw new RuntimeException("권한이 없습니다.");
        }
        todoRepository.deleteById(todoDeleteRequest.getId());
    }
}
