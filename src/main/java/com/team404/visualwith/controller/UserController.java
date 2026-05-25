package com.team404.visualwith.controller;

import com.team404.visualwith.dto.UserResponseDto;
import com.team404.visualwith.entity.User;
import com.team404.visualwith.repository.UserRepository;
import com.team404.visualwith.service.UserTeamService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {
    private final UserRepository userRepository;
    private final UserTeamService userTeamService;

    public UserController(UserRepository userRepository, UserTeamService userTeamService) {
        this.userRepository = userRepository;
        this.userTeamService = userTeamService;
    }

    @GetMapping("/{userId}")
    public ResponseEntity<?> getUserId(@PathVariable String userId) {
        User user = userRepository.findByUserId(userId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "사용자를 찾을 수 없습니다."));
        return ResponseEntity.ok(new UserResponseDto(user));
    }

    @GetMapping("/{userId}/teamList")
    public List<ResponseEntity<?>> getTeamList(@PathVariable String userId) {
        // TODO
        return null;
    }
}
