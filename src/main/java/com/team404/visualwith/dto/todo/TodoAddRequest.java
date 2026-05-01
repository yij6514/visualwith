package com.team404.visualwith.dto.todo;

public class TodoAddRequest {
    private String teamid;
    private String userId;
    private String title;
    private String content;
    private String createdDate;
    private String createdTime;

    public TodoAddRequest() {}

    //Getter
    public String getTeamId() {return teamid;}
    public String getUserId() {return userId;}

    public String getTitle() {return title;}
    public String getContent() {return content;}

    public String getCreatedDate() {return createdDate;}
    public String getCreatedTime() {return createdTime;}

    //Setter
    public void setTeamId(String teamid) {this.teamid = teamid;}
    public void setUserId(String userId) {this.userId = userId;}

    public void setTitle(String title) {this.title = title;}
    public void setContent(String content) {this.content = content;}

    public void setCreatedDate(String createdDate) {this.createdDate = createdDate;}
    public void setCreatedTime(String createdTime) {this.createdTime = createdTime;}
}
