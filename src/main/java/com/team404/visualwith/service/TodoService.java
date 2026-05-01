package com.team404.visualwith.service;

import com.team404.visualwith.dto.todo.*;
import com.team404.visualwith.entity.Todo;
import com.team404.visualwith.entity.UserTeamRole;
import com.team404.visualwith.repository.TodoRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TodoService {
    private final TodoRepository todoRepository;

    public TodoService(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    //TODO
    public TodoAddResponse createTodo(TodoAddRequest todoAddRequest) {
        Todo todo = new Todo(todoAddRequest);
        todoRepository.save(todo);
        return new TodoAddResponse(todo.getId());
    }

    public List<TodoGetResponse> getTodo(String teamId) {
        List<Todo> todoList = todoRepository.findByTeamId(teamId);
        List<TodoGetResponse> dtoList = new ArrayList<>();
        for(Todo todo : todoList) {
            dtoList.add(new TodoGetResponse(todo));
        }
        return dtoList;
    }

    public void updateTodo(TodoUpdateRequest todoUpdateRequest) {
        Todo todo = todoRepository.findById(todoUpdateRequest.getId())
                .orElseThrow(() -> new RuntimeException("Todo 없음"));
        if(!(todoUpdateRequest.getUserId().equals(todo.getCreatorId())
                || todoUpdateRequest.getUserTeamRole() == UserTeamRole.SUB_ADMIN
                || todoUpdateRequest.getUserTeamRole() == UserTeamRole.ADMIN)) {
            throw new RuntimeException("권한이 없습니다.");
        }
        todo.setTitle(todoUpdateRequest.getTitle());
        todo.setContent(todoUpdateRequest.getContent());
        todo.setModifierId(todoUpdateRequest.getUserId());
        todoRepository.save(todo);
    }

    public void completeTodo(TodoCompleteRequest todoCompleteRequest) {
        Todo todo = todoRepository.findById(todoCompleteRequest.getId())
                .orElseThrow(() -> new RuntimeException("Todo 없음"));
        if(!(todoCompleteRequest.getUserId().equals(todo.getCreatorId())
                || todoCompleteRequest.getUserTeamRole() == UserTeamRole.SUB_ADMIN
                || todoCompleteRequest.getUserTeamRole() == UserTeamRole.ADMIN)) {
            throw new RuntimeException("권한이 없습니다.");
        }
        todo.setModifierId(todoCompleteRequest.getUserId());
        todo.setCompleted(todoCompleteRequest.getComplete());
        todo.setCompleteDate(todoCompleteRequest.getCompleteDate());
        todo.setCompleteTime(todoCompleteRequest.getCompleteTime());
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
