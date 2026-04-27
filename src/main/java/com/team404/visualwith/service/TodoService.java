package com.team404.visualwith.service;

import com.team404.visualwith.dto.todo.*;
import com.team404.visualwith.entity.Todo;
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

        return null;
    }

    public List<TodoGetResponse> getTodo(String teamId) {
        List<Todo> todoList = todoRepository.findByTeamId(teamId);
        List<TodoGetResponse> dtoList = new ArrayList<>();
        for(Todo todo : todoList) {
            dtoList.add(new TodoGetResponse(
                    todo.getCreatorId(),
                    todo.getTitle(),
                    todo.getContent()));
        }
        return dtoList;
    }

    public void updateTodo(TodoUpdateRequest todoUpdateRequest) {
        Todo todo = todoRepository.findById(todoUpdateRequest.getId())
                .orElseThrow(() -> new RuntimeException("Todo 없음"));
        if(todoUpdateRequest.getUserId().equals(todo.getCreatorId())
                || todoUpdateRequest.getUserTeamRole() == ) {}
    }

    public void deleteTodo(TodoDeleteRequest todoDeleteRequest){

    }
}
