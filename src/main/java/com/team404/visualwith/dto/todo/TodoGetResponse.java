package com.team404.visualwith.dto.todo;

import com.team404.visualwith.entity.Todo;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TodoGetResponse {
    private Long id;
    private String userId;
    private String title;
    private String content;
    private Boolean completed;
    private LocalDate completeDate;
    private LocalTime completeTime;

    public TodoGetResponse(Todo todo) {
        this.id = todo.getId();
        this.userId = todo.getCreatorId();
        this.title = todo.getTitle();
        this.content = todo.getContent();
        this.completed = todo.getCompleted();
        this.completeDate = todo.getCompleteDate();
        this.completeTime = todo.getCompleteTime();
    }
}
