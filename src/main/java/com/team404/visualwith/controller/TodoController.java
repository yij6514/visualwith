package com.team404.visualwith.controller;

import com.team404.visualwith.dto.todo.*;
import com.team404.visualwith.entity.Todo;
import com.team404.visualwith.service.TodoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

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
         TodoAddResponse result =  todoService.createTodo(todoAddRequest);
        return ResponseEntity.ok(result);
    }

    // update
    @PutMapping("/update")
    public ResponseEntity<?> updateTodo(@RequestBody TodoUpdateRequest todoUpdateRequest){
        try {
            todoService.updateTodo(todoUpdateRequest);
        }
        catch(RuntimeException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(Map.of("message", e.getMessage()));
        }
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    // complete
    @PutMapping("/complete")
    public ResponseEntity<?> completeTodo(@RequestBody TodoCompleteRequest todoCompleteRequest){
        try{
            todoService.completeTodo(todoCompleteRequest);
        }
        catch(RuntimeException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(Map.of("message", e.getMessage()));
        }
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    //delete
    @DeleteMapping("/delete")
    public ResponseEntity<?> deleteTodo(@RequestBody TodoDeleteRequest todoDeleteRequest) {
        try{
            todoService.deleteTodo(todoDeleteRequest);
        }
        catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(Map.of("message", e.getMessage()));
        }
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
