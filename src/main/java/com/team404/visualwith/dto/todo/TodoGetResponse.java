package com.team404.visualwith.dto.todo;

import com.team404.visualwith.entity.Todo;

public class TodoGetResponse {
    private String userId;
    private String title;
    private String content;

    public TodoGetResponse() {}

    public TodoGetResponse(String userId, String title, String content) {
        this.userId = userId;
        this.title = title;
        this.content = content;
    }

    public TodoGetResponse(Todo todo) {
        this.userId = todo.getCreatorId();
        this.title = todo.getTitle();
        this.content = todo.getContent();
    }

    //Getter
    public String getUserId() {return userId;}
    public String getTitle() {return title;}
    public String getContent() {return content;}

    //Setter
    public void setUserId(String userId) {this.userId = userId;}
    public void setTitle(String title) {this.title = title;}
    public void setContent(String content) {this.content = content;}
}
