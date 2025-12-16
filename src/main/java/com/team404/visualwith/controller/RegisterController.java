package com.team404.visualwith.controller;

import com.team404.visualwith.dto.UserRegisterRequestDto;
import com.team404.visualwith.dto.UserResponseDto;
import com.team404.visualwith.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api")
public class RegisterController {

    private final UserService userService;

    public RegisterController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public ResponseEntity<UserResponseDto> register(@RequestBody UserRegisterRequestDto dto) {
        UserResponseDto response = userService.register(dto);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/checkid")
    public ResponseEntity<Map<String, Boolean>> checkid(@RequestBody Map<String, String> body) {
        Map<String, Boolean> response = userService.checkId(body);
        return ResponseEntity.ok(response);
    }
}
