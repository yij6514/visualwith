package com.team404.visualwith.controller;

import com.team404.visualwith.dto.TeamCreateRequest;
import com.team404.visualwith.dto.TeamCreateResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class TeamCreateController {
    @PostMapping("/createteam")
    public ResponseEntity<TeamCreateResponse> createTeam(@RequestBody TeamCreateRequest teamRequest) {
        return null;
    }
}
