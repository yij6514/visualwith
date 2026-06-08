package com.team404.visualwith.controller;

import com.team404.visualwith.dto.todo.*;
import com.team404.visualwith.entity.Todo;
import com.team404.visualwith.service.TodoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
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

    // 할 일 조회
    @GetMapping("/{teamId}")
    public List<TodoGetResponse> getTodoList(@PathVariable String teamId) {
        return todoService.getTodo(teamId);
    }

    // 할 일 생성
    @PostMapping
    public ResponseEntity<?> postTodo(@RequestBody TodoAddRequest todoAddRequest,
                                      Authentication auth) {
        TodoAddResponse result =  todoService.createTodo(todoAddRequest, auth.getName());
        return ResponseEntity.ok(result);
    }

    // 할 일 수정
    @PutMapping("/update")
    public ResponseEntity<?> updateTodo(@RequestBody TodoUpdateRequest todoUpdateRequest,
                                        Authentication auth){
        try {
            todoService.updateTodo(todoUpdateRequest, auth.getName());
        }
        catch(RuntimeException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(Map.of("message", e.getMessage()));
        }
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    // complete
    @PutMapping("/complete")
    public ResponseEntity<?> completeTodo(@RequestBody TodoCompleteRequest todoCompleteRequest,
                                          Authentication auth){
        try{
            todoService.completeTodo(todoCompleteRequest, auth.getName());
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
