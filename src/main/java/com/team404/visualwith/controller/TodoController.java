package com.team404.visualwith.controller;

import com.team404.visualwith.dto.todo.*;
import com.team404.visualwith.service.TodoService;
import org.springframework.http.HttpStatus;
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
        return todoService.getTodo(teamId);
    }

    // create
    @PostMapping
    public ResponseEntity<?> postTodo(@RequestBody TodoAddRequest todoAddRequest) {
        todoService.createTodo(todoAddRequest);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    // update
    @PutMapping
    public ResponseEntity<?> updateTodo(@RequestBody TodoUpdateRequest todoUpdateRequest){
        todoService.updateTodo(todoUpdateRequest);
        return null;
    }

    // complete
    @PutMapping
    public ResponseEntity<?> completeTodo(@RequestBody TodoCompleteRequest todoCompleteRequest){
        return null;
    }

    //delete
    @DeleteMapping("/{teamId}")
    public ResponseEntity<?> deleteTodo(@RequestBody TodoDeleteRequest todoDeleteRequest) {
        todoService.deleteTodo(todoDeleteRequest);
        return null;
    }
}
