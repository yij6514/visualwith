package com.team404.visualwith.service;

import com.team404.visualwith.dto.GetMeResponse;
import com.team404.visualwith.dto.UserRegisterRequestDto;
import com.team404.visualwith.dto.UserResponseDto;
import com.team404.visualwith.entity.User;
import com.team404.visualwith.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public UserResponseDto register(UserRegisterRequestDto dto) {
        if(userRepository.findByUserId(dto.getUserId()).isPresent()) {
            throw new IllegalArgumentException("이미 존재하는 아이디 입니다.");
        }

        String encodedPassword = passwordEncoder.encode(dto.getPassword());
        User user = new User(dto.getUserId(), encodedPassword, dto.getEmail(), dto.getName());
        User saved = userRepository.save(user);

        return new UserResponseDto(saved);
    }

    public Map<String, Boolean> checkId(Map<String, String> user) {
        String userId = user.get("userId");
        boolean exists = userRepository.existsByUserId(userId);
        Map<String, Boolean> response = new HashMap<>();
        response.put("available", !exists);

        return response;
    }

    public GetMeResponse getMe(String userId) {
        User user = userRepository.findByUserId(userId)
                .orElseThrow(() -> new RuntimeException("대상 사용자가 없습니다."));
        return new GetMeResponse(user);
    }
}
