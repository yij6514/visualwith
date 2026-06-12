package com.team404.visualwith.service;

import com.team404.visualwith.dto.AddTeamMemberRequest;
import com.team404.visualwith.dto.TeamtoUserGetResponse;
import com.team404.visualwith.dto.UsertoTeamGetResponse;
import com.team404.visualwith.entity.*;
import com.team404.visualwith.repository.TeamRepository;
import com.team404.visualwith.repository.UserRepository;
import com.team404.visualwith.repository.UserTeamRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserTeamService {
    private final UserRepository userRepository;
    private final TeamRepository teamRepository;
    private final UserTeamRepository userTeamRepository;

    public UserTeamService(UserRepository userRepository, TeamRepository teamRepository, UserTeamRepository userTeamRepository) {
        this.userRepository = userRepository;
        this.teamRepository = teamRepository;
        this.userTeamRepository = userTeamRepository;
    }

    public void addMember(String teamId, String adminUserId, String targetUserId) {
        Team team = teamRepository.findById(teamId)
                .orElseThrow(() -> new IllegalArgumentException("팀이 존재하지 않습니다."));
        User targetUser = userRepository.findByUserId(targetUserId)
                .orElseThrow(() -> new IllegalArgumentException("대상 사용자가 없습니다."));
        User adminUser = userRepository.findByUserId(adminUserId)
                .orElseThrow(() -> new SecurityException("요청자의 정보가 올바르지 않습니다."));
        UserTeam adminUserTeam = userTeamRepository.findById(new UserTeamId(adminUserId, teamId))
                .orElseThrow(() -> new SecurityException("요청자가 팀의 멤버가 아닙니다."));

        if(adminUserTeam.getRole() == UserTeamRole.MEMBER) {
            throw new SecurityException("일반 멤버는 팀원을 추가 할 수 없습니다.");
        }

        UserTeam targetUserTeam = new UserTeam(new UserTeamId(targetUserId, teamId), UserTeamRole.MEMBER, InvitationStatus.PENDING);
        userTeamRepository.save(targetUserTeam);
    }

    public void invitationUrlAccepted(String teamId, String invitationCode, String userId) {
        Team targetTeam = teamRepository.findById(teamId)
                .orElseThrow(() -> new IllegalArgumentException("팀이 존재하지 않습니다."));
        User targetUser = userRepository.findByUserId(userId)
                .orElseThrow(() -> new IllegalArgumentException("대상 사용자가 없습니다."));

        UserTeam targetUserTeam = new UserTeam(new UserTeamId(userId, teamId), UserTeamRole.MEMBER, InvitationStatus.ACCEPTED);
        userTeamRepository.save(targetUserTeam);
    }

    public void invitationAccepted(String teamId, String userId) {
        Team targetTeam = teamRepository.findById(teamId)
                .orElseThrow(() -> new IllegalArgumentException("팀이 존재하지 않습니다."));
        User targetUser = userRepository.findByUserId(userId)
                .orElseThrow(() -> new IllegalArgumentException("대상 사용자가 존재하지 않습니다."));
        UserTeam targetUserTeam = userTeamRepository.findById(new UserTeamId(userId, teamId))
                .orElseThrow(() -> new IllegalArgumentException("팀에 초대되지 않았습니다."));

        targetUserTeam.setStatus(InvitationStatus.ACCEPTED);
        userTeamRepository.save(targetUserTeam);
    }

    public List<TeamtoUserGetResponse> getMemberList(String teamId) {
        List<UserTeam> memberList = userTeamRepository.findByIdTeamId(teamId);
        List<TeamtoUserGetResponse> dtoList = new ArrayList<>();

        for(UserTeam userTeam : memberList) {
            User user = userRepository.findByUserId(userTeam.getId().getUserId())
                    .orElseThrow(() -> new IllegalArgumentException("대상 사용자가 없습니다."));
            dtoList.add(new TeamtoUserGetResponse(userTeam, user));
        }

        return dtoList;
    }

    public List<UsertoTeamGetResponse> getTeamList(String userId) {
        List<UserTeam> teamList = userTeamRepository.findByIdUserId(userId);
        List<UsertoTeamGetResponse> dtoList = new ArrayList<>();

        for(UserTeam userTeam : teamList) {
            Team team = teamRepository.findById(userTeam.getId().getTeamId())
                    .orElseThrow(() -> new IllegalArgumentException("대상 팀이 없습니다."));
            dtoList.add(new UsertoTeamGetResponse(userTeam, team));
        }

        return dtoList;
    }
}
