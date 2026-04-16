package com.team404.visualwith.dto.todo;

public class TodoGetResponse {
    private String userId;
    private String title;
    private String content;

    public TodoGetResponse() {}

    //Getter
    public String getUserId() {return userId;}
    public String getTitle() {return title;}
    public String getContent() {return content;}

    //Setter
    public void setUserId(String userId) {this.userId = userId;}
    public void setTitle(String title) {this.title = title;}
    public void setContent(String content) {this.content = content;}
}
