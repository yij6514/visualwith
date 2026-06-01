package com.team404.visualwith.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "user_teams")
public class UserTeam {
    @EmbeddedId
    private UserTeamId id;

    @Enumerated(EnumType.STRING)
    @Column(name="role", nullable = false)
    private UserTeamRole role;

    @Enumerated(EnumType.STRING)
    private InvitationStatus status;

    public UserTeam() {}

    public UserTeam(UserTeamId id, UserTeamRole role, InvitationStatus status) {
        this.id = id;
        this.role = role;
        this.status = status;
    }
}
