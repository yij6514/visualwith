package com.team404.visualwith.dto;

import com.team404.visualwith.entity.InvitationStatus;
import com.team404.visualwith.entity.User;
import com.team404.visualwith.entity.UserTeam;
import com.team404.visualwith.entity.UserTeamRole;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class TeamtoUserGetResponse {
    private String userId;
    private String teamId;
    private UserTeamRole userTeamRole;
    private InvitationStatus invitationStatus;
    private String userName;

    public TeamtoUserGetResponse(UserTeam userTeam, User user) {
        this.userId = userTeam.getId().getUserId();
        this.teamId = userTeam.getId().getTeamId();
        this.userTeamRole = userTeam.getRole();
        this.invitationStatus = userTeam.getStatus();
        this.userName = user.getName();
    }
}
