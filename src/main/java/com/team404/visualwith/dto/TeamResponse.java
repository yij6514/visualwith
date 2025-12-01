package com.team404.visualwith.dto;

public class TeamResponse {
    private Long id;
    private String teamName;
    private String description;
    private String creatorId;

    public TeamResponse(Long id, String teamName, String description, String creatorId) {
        this.id = id;
        this.teamName = teamName;
        this.description = description;
        this.creatorId = creatorId;
    }

    public Long getId() {return id;}
    public String getTeamName() {return teamName;}
    public String getDescription() {return description;}
    public String getCreatorId() {return creatorId;}
}
