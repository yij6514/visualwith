package com.team404.visualwith.dto.todo;

import com.team404.visualwith.entity.UserTeamRole;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TodoCompleteRequest {
    private String id;
    private String teamId;
    private String userId;
    private UserTeamRole userTeamRole;
    private String completeDate;
    private String completeTime;
    private Boolean complete;

    public TodoCompleteRequest() {}
}
