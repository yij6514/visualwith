package com.team404.visualwith.controller;

import com.team404.visualwith.dto.TeamCreateRequest;
import com.team404.visualwith.dto.TeamCreateResponse;
import com.team404.visualwith.service.TeamService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class TeamCreateController {
    private final TeamService teamService;

    public TeamCreateController(TeamService teamService) {
        this.teamService = teamService;
    }

    @PostMapping("/createteam")
    public ResponseEntity<TeamCreateResponse> createTeam(
            @RequestBody TeamCreateRequest teamRequest,
            @RequestHeader("X-USER-ID") String userId) {
        TeamCreateResponse response = teamService.createTeam(teamRequest.getTeamName(), userId);
        return ResponseEntity.ok(response);
    }
}
