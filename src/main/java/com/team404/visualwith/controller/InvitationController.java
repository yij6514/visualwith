package com.team404.visualwith.controller;

import com.team404.visualwith.dto.AddTeamMemberRequest;
import com.team404.visualwith.service.UserTeamService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/teams")
public class InvitationController {
    private final UserTeamService userTeamService;

    public InvitationController(UserTeamService userTeamService) {
        this.userTeamService = userTeamService;
    }

    @PostMapping("/invitation/{teamId}")
    public ResponseEntity<Void> addMember(
            @PathVariable String teamId,
            @RequestBody AddTeamMemberRequest request,
            @RequestHeader("X-USER-ID") String adminUserId) {
        userTeamService.addMember(teamId, adminUserId, request.getUserId());
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
