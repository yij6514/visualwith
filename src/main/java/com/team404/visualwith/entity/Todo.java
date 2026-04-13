package com.team404.visualwith.entity;

import jakarta.persistence.*;

@Entity
@Table(name="todos")
public class Todo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String userId;
    private String teamId;

    private String title;
    private String content;

    private Boolean completed;

    private String createdDate;
    private String createdTime;

    private String completeDate;
    private String completeTime;

    public Todo() {}

    public Todo(Long id, String title, String content,
                String createdDate, String createdTime,
                String completeDate, String completeTime,
                Boolean completed, String userId, String teamId) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.createdDate = createdDate;
        this.createdTime = createdTime;
        this.completeDate = completeDate;
        this.completeTime = completeTime;
        this.completed = completed;
        this.userId = userId;
        this.teamId = teamId;
    }

    //getter

    public Long getId() {return id;}

    public String getUserId() {return userId;}
    public String getTeamId() {return teamId;}

    public String getTitle() {return title;}
    public String getContent() {return content;}

    public Boolean getCompleted() {return completed;}

    public String getCreatedDate() {return createdDate;}
    public String getCreatedTime() {return createdTime;}

    public String getCompleteDate() {return completeDate;}
    public String getCompleteTime() {return completeTime;}

    //setter

    public void setUserId(String userId) {this.userId = userId;}
    public void setTeamId(String teamId) {this.teamId = teamId;}

    public void setTitle(String title) {this.title = title;}
    public void setContent(String content) {this.content = content;}

    public void setCompleted(Boolean completed) {this.completed = completed;}

    public void setCreatedDate(String createdDate) {this.createdDate = createdDate;}
    public void setCreatedTime(String createdTime) {this.createdTime = createdTime;}

    public void setCompleteDate(String completeDate) {this.completeDate = completeDate;}
    public void setCompleteTime(String completeTime) {this.completeTime = completeTime;}
}
