package com.team404.visualwith.dto.calendar;

import com.team404.visualwith.entity.UserTeamRole;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CalDeleteRequest {
    private Long id;
    private String teamId;
    private UserTeamRole userTeamRole;
}
