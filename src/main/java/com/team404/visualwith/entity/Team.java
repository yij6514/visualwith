package com.team404.visualwith.entity;

import jakarta.persistence.*;

@Entity
@Table(name="teams")
public class Team {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private Long teamId;

    @Column(nullable = false)
    private String teamName;

    private String description;

    @Column(nullable = false, name = "creator_id")
    private String createId;

    public Team() {}

    public Team(String teamName, String createId) {
        this.teamName = teamName;
        this.createId = createId;
    }

    public Long getId() {return teamId;}
    public String getTeamName() {return teamName;}
    public String getDescription() {return description;}
    public String getCreateId() {return createId;}

    public void setTeamName(String teamName) {this.teamName = teamName;}
    public void setDescription(String description) {this.description = description;}
    public void setCreateId(String createId) {this.createId = createId;}
}
