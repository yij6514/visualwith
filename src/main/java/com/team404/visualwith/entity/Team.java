package com.team404.visualwith.entity;

import jakarta.persistence.*;

import java.util.Random;

@Entity
@Table(name="teams")
public class Team {
    @Id
    @Column(nullable = false, unique = true)
    private String id;

    @Column(nullable = false)
    private String teamName;

    @Column(nullable = false, name = "creator_id")
    private String createId;

    public Team() {}

    public Team(String id, String teamName, String createId) {
        this.id = id;
        this.teamName = teamName;
        this.createId = createId;
    }

    public String getId() {return id;}
    public String getTeamName() {return teamName;}
    public String getCreateId() {return createId;}

    public void setTeamName(String teamName) {this.teamName = teamName;}
    public void setCreateId(String createId) {this.createId = createId;}
}
