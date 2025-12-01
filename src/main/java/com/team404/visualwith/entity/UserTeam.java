package com.team404.visualwith.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "user_teams")
public class UserTeam {
    private String userId;
    private String teamId;
    private String role;
}
