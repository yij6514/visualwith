package com.team404.visualwith.controller;

import com.team404.visualwith.dto.UserResponseDto;
import com.team404.visualwith.entity.User;
import com.team404.visualwith.repository.UserRepository;
import com.team404.visualwith.service.UserService;
import com.team404.visualwith.service.UserTeamService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/users")
public class UserController {
    private final UserRepository userRepository;
    private final UserTeamService userTeamService;
    private final UserService userService;

    // 사용자 ID로 사용자 찾기
    @GetMapping("/{userId}")
    public ResponseEntity<?> getUserId(@PathVariable String userId) {
        User user = userRepository.findByUserId(userId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "사용자를 찾을 수 없습니다."));
        return ResponseEntity.ok(new UserResponseDto(user));
    }

    // 사용자의 팀 리스트 반환
    @GetMapping("/{userId}/teamList")
    public ResponseEntity<?> getTeamList(@PathVariable String userId,
                                         Authentication auth) {
        // TODO
        return ResponseEntity.status(HttpStatus.OK)
                .body(userTeamService.getTeamList(auth.getName()));
    }

    // 현재 사용자가 누군지 알기위한 api
    @GetMapping("/me")
    public ResponseEntity<?> getMe(Authentication auth) {
        try{
            return ResponseEntity.status(HttpStatus.OK)
                    .body(userService.getMe(auth.getName()));
        }
        catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(Map.of("message", e.getMessage()));
        }
    }
}
