package com.team404.visualwith.dto;

import com.team404.visualwith.entity.User;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class GetMeResponse {
    private String userId;
    private String name;
    private String email;

    public GetMeResponse(User user) {
        this.userId = user.getUserId();
        this.name = user.getName();
        this.email = user.getEmail();
    }
}
