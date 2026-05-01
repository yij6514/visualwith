package com.team404.visualwith.dto.todo;

import com.team404.visualwith.entity.Todo;

public class TodoGetResponse {
    private Long id;
    private String userId;
    private String title;
    private String content;
    private Boolean completed;

    public TodoGetResponse() {}

    public TodoGetResponse(Long id, String userId, String title, String content, Boolean completed) {
        this.id = id;
        this.userId = userId;
        this.title = title;
        this.content = content;
        this.completed = completed;
    }

    public TodoGetResponse(Todo todo) {
        this.id = todo.getId();
        this.userId = todo.getCreatorId();
        this.title = todo.getTitle();
        this.content = todo.getContent();
        this.completed = todo.getCompleted();
    }

    //Getter
    public Long getId() {return id;}
    public String getUserId() {return userId;}
    public String getTitle() {return title;}
    public String getContent() {return content;}
    public Boolean getCompleted() {return completed;}

    //Setter
    public void setId(Long id) {this.id = id;}
    public void setUserId(String userId) {this.userId = userId;}
    public void setTitle(String title) {this.title = title;}
    public void setContent(String content) {this.content = content;}
    public void setCompleted(Boolean completed) {this.completed = completed;}
}
