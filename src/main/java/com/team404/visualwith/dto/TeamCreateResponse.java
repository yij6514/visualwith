package com.team404.visualwith.dto;

public class TeamCreateResponse {
    private String id;
    private String teamName;
    private String creatorId;

    public TeamCreateResponse(String id, String teamName, String creatorId) {
        this.id = id;
        this.teamName = teamName;
        this.creatorId = creatorId;
    }

    public String getId() {return id;}
    public String getTeamName() {return teamName;}
    public String getCreatorId() {return creatorId;}
}
