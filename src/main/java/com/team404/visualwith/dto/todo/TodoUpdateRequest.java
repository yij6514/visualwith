package com.team404.visualwith.dto.todo;

import com.team404.visualwith.entity.UserTeamRole;

public class TodoUpdateRequest {
    private String id;
    private String teamId;
    private String userId;
    private UserTeamRole userTeamRole;
    private String title;
    private String content;

    //Constructor 생성자
    public TodoUpdateRequest() {}

    //Getter
    public String getId() {return id;}

    public String getTeamId() {return teamId;}
    public String getUserId() {return userId;}
    public UserTeamRole getUserTeamRole() {return userTeamRole;}

    public String getTitle() {return title;}
    public String getContent() {return content;}

    //Setter
    public void setId(String id) {this.id = id;}

    public void setTeamId(String teamId) {this.teamId = teamId;}
    public void setUserId(String userId) {this.userId = userId;}
    public void setUserTeamRole(UserTeamRole userTeamRole) {this.userTeamRole = userTeamRole;}

    public void setTitle(String title) {this.title = title;}
    public void setContent(String content) {this.content = content;}
}
