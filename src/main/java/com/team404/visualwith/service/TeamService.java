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

    public void deleteTeam(String teamId, String requesterId) {

        Team team = teamRepository.findById(teamId)
                .orElseThrow(() -> new RuntimeException("팀을 찾을 수 없습니다."));

        // 생성자인지 검증
        if (!team.getCreateId().equals(requesterId)) {
            throw new RuntimeException("팀 생성자만 팀을 삭제할 수 있습니다.");
        }

        // user_team 관계 먼저 삭제
        userTeamRepository.deleteByIdTeamId(teamId);

        // 팀 삭제
        teamRepository.delete(team);
    }
}