package com.team404.visualwith.controller;

import com.team404.visualwith.dto.AddTeamMemberRequest;
import com.team404.visualwith.service.UserTeamService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/teams")
public class InvitationController {
    private final UserTeamService userTeamService;

    public InvitationController(UserTeamService userTeamService) {
        this.userTeamService = userTeamService;
    }

    @PostMapping("/invitation/{teamId}")
    public ResponseEntity<?> addMember(
            @PathVariable String teamId,
            @RequestBody AddTeamMemberRequest request,
            @RequestHeader("X-USER-ID") String adminUserId) {
        try{
            userTeamService.addMember(teamId, adminUserId, request.getUserId());
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body(Map.of("message", "팀 초대 완료"));
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(Map.of("message", e.getMessage()));
        } catch (SecurityException e) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN)
                    .body((Map.of("message", e.getMessage())));
        }

    }
}
