package com.team404.visualwith.dto.todo;

import com.team404.visualwith.entity.UserTeamRole;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TodoUpdateRequest {
    private String id;
    private String teamId;
    private String userId;
    private UserTeamRole userTeamRole;
    private String title;
    private String content;

    //Constructor 생성자
    public TodoUpdateRequest() {}
}
