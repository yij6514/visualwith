package com.team404.visualwith.entity;

import com.team404.visualwith.dto.todo.TodoAddRequest;
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

    public Todo(TodoAddRequest todoAddRequest) {
        this.title = todoAddRequest.getTitle();
        this.content = todoAddRequest.getContent();
        this.createdDate = LocalDate.now();
        this.createdTime = LocalTime.now();
        this.creatorId = todoAddRequest.getUserId();
        this.teamId = todoAddRequest.getTeamId();
        this.completed = false;
    }
}
