package com.team404.visualwith.dto.calendar;

import com.team404.visualwith.entity.UserTeamRole;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CalUpdateRequest {
    private Long id;
    private String teamId;
    private String userId;
    private UserTeamRole userTeamRole;
    private String title;
    private String content;
    private String startDate;
    private String startTime;
    private String completeDate;
    private String completeTime;
    private Boolean wholeDay;
}
