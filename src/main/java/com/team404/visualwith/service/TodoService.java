package com.team404.visualwith.service;

import com.team404.visualwith.dto.todo.*;
import com.team404.visualwith.repository.TodoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

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

        return null;
    }

    public void deleteTodo(TodoDeleteRequest todoDeleteRequest){

    }
}
