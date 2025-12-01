package com.team404.visualwith.dto;

public class TeamRequest {
    private String createorId;
    private String teamName;

    public TeamRequest() {}

    public String getCreateorId() {return createorId;}
    public String getTeamName() {return teamName;}

    public void setCreateorId(String createorId) {this.createorId = createorId;}
    public void setTeamName(String teamName) {this.teamName = teamName;}
}
