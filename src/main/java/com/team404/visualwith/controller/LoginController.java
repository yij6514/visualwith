package com.team404.visualwith.controller;

import com.team404.visualwith.config.JwtTokenProvider;
import com.team404.visualwith.dto.LoginRequest;
import com.team404.visualwith.dto.LoginResponse;
import com.team404.visualwith.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseCookie;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api")
public class LoginController {
    private final AuthService authService;
    private final JwtTokenProvider jwtTokenProvider;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {
        try{
            LoginResponse response = authService.login(loginRequest);
            String token = jwtTokenProvider.createToken(loginRequest.getUserId());
            ResponseCookie cookie = ResponseCookie.from("accessToken", token)
                    .httpOnly(true)
                    .path("/")
                    .maxAge(60 * 60)
                    .build();

            return ResponseEntity.ok()
                    .header(HttpHeaders.SET_COOKIE, cookie.toString())
                    .body(response);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                    .body(Map.of("message", e.getMessage()));
        }
    }
}
