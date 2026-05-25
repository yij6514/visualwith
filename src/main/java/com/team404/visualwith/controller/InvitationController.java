package com.team404.visualwith.controller;

import com.team404.visualwith.dto.AddTeamMemberRequest;
import com.team404.visualwith.service.TeamService;
import com.team404.visualwith.service.UserTeamService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/teams")
public class InvitationController {
    private final UserTeamService userTeamService;
    private final TeamService teamService;

    public InvitationController(UserTeamService userTeamService,  TeamService teamService) {
        this.userTeamService = userTeamService;
        this.teamService = teamService;
    }

    // 지정초대
    // TODO 수정해야됨
    @PostMapping("/invitation/{teamId}")
    public ResponseEntity<?> addMember(
            @PathVariable String teamId,
            @RequestBody AddTeamMemberRequest request,
            @RequestHeader("X-USER-ID") String adminUserId) {
        try{
            userTeamService.addMember(teamId, adminUserId, request.getUserId());
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(Map.of("message", e.getMessage()));
        } catch (SecurityException e) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN)
                    .body((Map.of("message", e.getMessage())));
        }
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(Map.of("message", "팀 초대 완료"));
    }

    // url 초대 
    @GetMapping("/invitation/{teamId}/geturl")
    public ResponseEntity<?> getInvitationURL(@PathVariable String teamId) {
        try {
            // url이 없으면 createurl 사용
            String invitationUrl = teamId + "/" + teamService.getTeamUrl(teamId);
            return ResponseEntity.status(HttpStatus.OK)
                    .body(Map.of("url", invitationUrl));
        }
        catch (SecurityException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(Map.of("message", e.getMessage()));
        }
    }

    // url 초대 수락
    @PutMapping("/invitation/{teamId}/{invitationCode}")
    public ResponseEntity<?> invitationAcceptUrl(@PathVariable String teamId, @PathVariable String invitationCode) {
        // TODO
        return null;
    }

    // 지정초대 수락
    @PutMapping("/invitation/{teamId}/{userId}")
    public ResponseEntity<?> inviationAccept(@PathVariable String teamId, @PathVariable String userId) {
        // TODO
        return null;
    }

}
