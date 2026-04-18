package com.team404.visualwith.controller;

import com.team404.visualwith.dto.todo.TodoAddRequest;
import com.team404.visualwith.dto.todo.TodoGetResponse;
import com.team404.visualwith.service.TodoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/todo")
public class TodoController {
    private final TodoService todoService;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    // read
    @GetMapping("/{teamId}")
    public List<TodoGetResponse> getTodoList(@PathVariable String teamId) {
        todoService.getTodo(teamId);
        return null;
    }

    // create
    @PostMapping
    public ResponseEntity<?> postTodo(@RequestBody TodoAddRequest todoAddRequest) {

        return null;
    }

    // update

    // complete

    //delete
}
