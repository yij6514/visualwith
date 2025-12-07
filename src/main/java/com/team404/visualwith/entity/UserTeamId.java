package com.team404.visualwith.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class UserTeamId {

    @Column(name = "user_id")
    private String userId;

    @Column(name = "team_id")
    private String teamId;

    public UserTeamId() {}

    public UserTeamId(String userId, String teamId) {
        this.userId = userId;
        this.teamId = teamId;
    }

    @Override
    public boolean equals(Object o) {
        if(this == o) return true;
        if(!(o instanceof UserTeamId)) return false;

        UserTeamId tmp = (UserTeamId) o;

        if(!userId.equals(tmp.userId)) return false;
        return teamId.equals(tmp.teamId);
    }

    @Override
    public int hashCode() {
        int result = userId.hashCode();
        result = 31 * result + teamId.hashCode();
        return result;
    }
}
