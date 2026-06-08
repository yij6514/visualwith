package com.team404.visualwith.entity;

import com.team404.visualwith.dto.todo.TodoAddRequest;
import com.team404.visualwith.dto.todo.TodoCompleteRequest;
import com.team404.visualwith.dto.todo.TodoUpdateRequest;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Getter
@Setter
@AllArgsConstructor
@Table(name="todos")
public class Todo {

    // 할일목록 ID
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;

    @Column(nullable = false)
    private String creatorId; // 작성자 ID
    private String modifierId; // 수정자 ID

    @Column(nullable = false)
    private String teamId;

    @Column(nullable = false)
    private String title;
    private String content;

    @Column(nullable = false)
    private Boolean completed;

    private LocalDate createdDate;
    private LocalTime createdTime;

    private LocalDate completeDate;
    private LocalTime completeTime;

    public Todo() {}

    public Todo(TodoAddRequest todoAddRequest, String userId) {
        this.title = todoAddRequest.getTitle();
        this.content = todoAddRequest.getContent();
        this.createdDate = LocalDate.now();
        this.createdTime = LocalTime.now();
        this.creatorId = userId;
        this.teamId = todoAddRequest.getTeamId();
        this.completed = false;
    }

    public void update(TodoUpdateRequest request) {
        this.title = request.getTitle();
        this.content = request.getContent();
        this.modifierId = request.getUserId();
    }

    public void complete(TodoCompleteRequest request) {
        this.completeDate = LocalDate.parse(request.getCompleteDate());
        this.completeTime = LocalTime.parse(request.getCompleteTime());
        this.modifierId = request.getUserId();
        this.completed = request.getComplete();
    }
}
