package com.team404.visualwith.dto.todo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TodoAddRequest {
    private String teamId;
    private String userId;
    private String title;
    private String content;
    private String createdDate;
    private String createdTime;

    public TodoAddRequest() {}
}
