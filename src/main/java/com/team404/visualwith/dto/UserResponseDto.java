package com.team404.visualwith.dto;

import com.team404.visualwith.entity.User;
import lombok.Getter;

@Getter
public class UserResponseDto {
    //응답 DTO에서는 비밀번호를 보여줘야 할 필요가 없어서 비밀번호 제외
    private Long id;
    private String user_id;
    private String name;
    private String email;

    public UserResponseDto(User user) {
        this.id = user.getId();
        this.user_id = user.getUserId();
        this.email = user.getEmail();
        this.name = user.getName();
    }
}
