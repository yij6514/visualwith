package com.team404.visualwith.service;

import com.team404.visualwith.dto.TeamCreateResponse;
import com.team404.visualwith.entity.*;
import com.team404.visualwith.repository.TeamRepository;
import com.team404.visualwith.repository.UserTeamRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Random;

@Service
public class TeamService {
    private final TeamRepository teamRepository;
    private final UserTeamRepository userTeamRepository;

    public TeamService(TeamRepository teamRepository, UserTeamRepository userTeamRepository) {
        this.teamRepository = teamRepository;
        this.userTeamRepository = userTeamRepository;
    }

    // 팀 id 생성 메소드 -> 팀생성 메소드에서 사용
    private String generateSlug(int length) {
        final String CHARS = "abcdefghijklmnopqrstuvwxyz0123456789";
        Random random = new Random();
        StringBuilder slug = new StringBuilder();

        for (int i = 0; i < length; i++) {
            slug.append(CHARS.charAt(random.nextInt(CHARS.length())));
        }
        return slug.toString();
    }

    // 팀 생성 메소드
    public TeamCreateResponse createTeam(String teamName, String creatorId) {
        String slug;
        do{
            slug = generateSlug(8);
        } while(teamRepository.existsById(slug));

        Team team = new Team(slug, teamName, creatorId, null, null);
        teamRepository.save(team);

        UserTeamId id = new UserTeamId(creatorId, slug);
        UserTeam userTeam = new UserTeam(id, UserTeamRole.ADMIN, InvitationStatus.ACCEPTED);
        userTeamRepository.save(userTeam);
        return new TeamCreateResponse(
                team.getId(),
                team.getTeamName(),
                team.getCreateId()
        );
    }

    // 팀 삭제 메소드
    public void deleteTeam(String teamId, String adminUserId) {
        Team team = teamRepository.findById(teamId)
                .orElseThrow(() -> new SecurityException("팀을 찾을 수 없습니다."));

        if (!team.getCreateId().equals(adminUserId)) {
            throw new IllegalArgumentException("팀 관리자만 팀을 삭제할 수 있습니다.");
        }

        userTeamRepository.deleteByIdTeamId(teamId);
        teamRepository.delete(team);
    }

    // 팀 url 반환 메소드
    // invitationController에서 사용
    public String getTeamUrl(String teamId) {
        Team team = teamRepository.findById(teamId)
                .orElseThrow(() -> new SecurityException("팀을 찾을 수 없습니다."));

        LocalDate oriDate = team.getUrlCreateDate();
        LocalDate now = LocalDate.now();

        if(team.getTeamUrl() == null || oriDate == null || ChronoUnit.DAYS.between(oriDate, now) >= 7) {
            createTeamUrl(teamId);
        }
        return team.getTeamUrl();
    }

    // 팀 url 생성 메소드
    // invitationController getInvitationUrl에서 사용
    private String createTeamUrl(String teamId) {
        Team team = teamRepository.findById(teamId)
                .orElseThrow(() -> new SecurityException("팀을 찾을 수 없습니다."));

        // url 생성
        String url;
        do{
            url = generateSlug(10);
        } while(teamRepository.existsByTeamUrl(url));

        team.setTeamUrl(url);
        team.setUrlCreateDate(LocalDate.now()); // url 생성시간
        teamRepository.save(team);
        return team.getTeamUrl();
    }
}