package com.team404.visualwith.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "user_teams")
public class UserTeam {
    @Embedded
    private UserTeamId id;

    @Enumerated(EnumType.STRING)
    @Column(name="role", nullable = false)
    private UserTeamRole role;

    public UserTeam() {}

    public UserTeam(UserTeamId id, UserTeamRole role) {
        this.id = id;
        this.role = role;
    }

    public UserTeamId getId() {return id;}
    public UserTeamRole getRole() {return role;}

    public void setId(UserTeamId id) {this.id = id;}
    public void setRole(UserTeamRole role) {this.role = role;}
}
