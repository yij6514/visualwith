package com.team404.visualwith.dto.todo;

import com.team404.visualwith.entity.UserTeamRole;

public class TodoCompleteRequest {
    private String id;
    private String teamId;
    private String userId;
    private UserTeamRole userTeamRole;
    private String completeDate;
    private String completeTime;
    private Boolean complete;

    public TodoCompleteRequest() {}

    //Getter
    public String getId() {return id;}

    public String getTeamId() {return teamId;}
    public String getUserId() {return userId;}
    public UserTeamRole getUserTeamRole() {return userTeamRole;}

    public String getCompleteDate() {return completeDate;}
    public String getCompleteTime() {return completeTime;}
    public Boolean getComplete() {return complete;}

    //Setter
    public void setId(String id) {this.id = id;}

    public void setTeamId(String teamId) {this.teamId = teamId;}
    public void setUserId(String userId) {this.userId = userId;}
    public void setUserTeamRole(UserTeamRole userTeamRole) {this.userTeamRole = userTeamRole;}

    public void setCompleteDate(String completeDate) {this.completeDate = completeDate;}
    public void setCompleteTime(String completeTime) {this.completeTime = completeTime;}
    public void setComplete(Boolean complete) {this.complete = complete;}
}
