package com.team404.visualwith.controller;

import com.team404.visualwith.dto.TeamCreateRequest;
import com.team404.visualwith.dto.TeamCreateResponse;
import com.team404.visualwith.service.TeamService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api")
public class TeamController {
    private final TeamService teamService;

    public TeamController(TeamService teamService) {
        this.teamService = teamService;
    }
    
    @PostMapping("/createteam")
    public ResponseEntity<TeamCreateResponse> createTeam(
            @RequestBody TeamCreateRequest teamRequest,
            @RequestHeader("X-USER-ID") String userId) {
        TeamCreateResponse response = teamService.createTeam(teamRequest.getTeamName(), userId);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/teams/{teamId}")
    public ResponseEntity<?> deleteTeam(
            @RequestHeader("X-USER-ID") String userId,
            @PathVariable String teamId) {
        try{
            teamService.deleteTeam(teamId, userId);
            return ResponseEntity.ok("팀 삭제 완료");
        } catch(SecurityException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(Map.of("message", e.getMessage()));
        } catch(IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN)
                    .body(Map.of("message", e.getMessage()));
        }
    }
}
