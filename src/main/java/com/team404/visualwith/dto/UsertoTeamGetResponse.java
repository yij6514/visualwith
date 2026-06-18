package com.team404.visualwith.dto;

import com.team404.visualwith.entity.InvitationStatus;
import com.team404.visualwith.entity.Team;
import com.team404.visualwith.entity.UserTeam;
import com.team404.visualwith.entity.UserTeamRole;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class UsertoTeamGetResponse {
    private String userId;
    private String teamId;
    private UserTeamRole userTeamRole;
    private InvitationStatus invitationStatus;
    private String teamName;

    public UsertoTeamGetResponse(UserTeam userTeam, Team team) {
        this.userId = userTeam.getId().getUserId();
        this.teamId = userTeam.getId().getTeamId();
        this.userTeamRole = userTeam.getRole();
        this.invitationStatus = userTeam.getStatus();
        this.teamName = team.getTeamName();
    }
}
