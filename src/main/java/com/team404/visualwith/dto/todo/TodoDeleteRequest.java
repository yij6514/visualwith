package com.team404.visualwith.dto.todo;

import com.team404.visualwith.entity.UserTeamRole;

public class TodoDeleteRequest {
    private String id;
    private String teamId;
    private String userId;
    private UserTeamRole userTeamRole;

    public TodoDeleteRequest() {}

    //Getter
    public String getId() {return id;}

    public String getTeamId() {return teamId;}
    public String getUserId() {return userId;}
    public UserTeamRole getUserTeamRole() {return userTeamRole;}

    //Setter
    public void setId(String id) {this.id = id;}

    public void setTeamId(String teamId) {this.teamId = teamId;}
    public void setUserId(String userId) {this.userId = userId;}
    public void setUserTeamRole(UserTeamRole userTeamRole) {this.userTeamRole = userTeamRole;}
}
