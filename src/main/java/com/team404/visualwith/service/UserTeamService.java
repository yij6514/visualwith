package com.team404.visualwith.service;

import com.team404.visualwith.entity.*;
import com.team404.visualwith.repository.TeamRepository;
import com.team404.visualwith.repository.UserRepository;
import com.team404.visualwith.repository.UserTeamRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

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

        UserTeam targetUserTeam = new UserTeam(new UserTeamId(targetUserId, teamId), UserTeamRole.MEMBER);
        userTeamRepository.save(targetUserTeam);
    }
}
