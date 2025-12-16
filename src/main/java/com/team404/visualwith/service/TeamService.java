package com.team404.visualwith.service;

import com.team404.visualwith.dto.TeamCreateResponse;
import com.team404.visualwith.entity.Team;
import com.team404.visualwith.entity.UserTeam;
import com.team404.visualwith.entity.UserTeamId;
import com.team404.visualwith.entity.UserTeamRole;
import com.team404.visualwith.repository.TeamRepository;
import com.team404.visualwith.repository.UserTeamRepository;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class TeamService {
    private final TeamRepository teamRepository;
    private final UserTeamRepository userTeamRepository;

    public TeamService(TeamRepository teamRepository, UserTeamRepository userTeamRepository) {
        this.teamRepository = teamRepository;
        this.userTeamRepository = userTeamRepository;
    }

    private String generateSlug(int length) {
        final String CHARS = "abcdefghijklmnopqrstuvwxyz0123456789";
        Random random = new Random();
        StringBuilder slug = new StringBuilder();

        for (int i = 0; i < length; i++) {
            slug.append(CHARS.charAt(random.nextInt(CHARS.length())));
        }
        return slug.toString();
    }

    public TeamCreateResponse createTeam(String teamName, String creatorId) {
        String slug;
        do{
            slug = generateSlug(8);
        } while(teamRepository.existsById(slug));

        Team team = new Team(slug, teamName, creatorId);
        teamRepository.save(team);

        UserTeamId id = new UserTeamId(creatorId, slug);
        UserTeam userTeam = new UserTeam(id, UserTeamRole.ADMIN);
        userTeamRepository.save(userTeam);
        return new TeamCreateResponse(
                team.getId(),
                team.getTeamName(),
                team.getCreateId()
        );
    }

    public void deleteTeam(String teamId, String adminUserId) {
        Team team = teamRepository.findById(teamId)
                .orElseThrow(() -> new RuntimeException("팀을 찾을 수 없습니다."));

        if (!team.getCreateId().equals(adminUserId)) {
            throw new RuntimeException("팀 관리자만 팀을 삭제할 수 있습니다.");
        }

        userTeamRepository.deleteByIdTeamId(teamId);
        teamRepository.delete(team);
    }
}