package com.team404.visualwith.service;

import com.team404.visualwith.dto.todo.*;
import com.team404.visualwith.entity.Todo;
import com.team404.visualwith.repository.TodoRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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

    public void deleteTodo(TodoDeleteRequest todoDeleteRequest){

    }
}
