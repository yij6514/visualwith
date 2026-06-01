package com.team404.visualwith.repository;

import com.team404.visualwith.entity.UserTeam;
import com.team404.visualwith.entity.UserTeamId;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserTeamRepository extends JpaRepository<UserTeam, UserTeamId> {
    @Transactional
    void deleteByIdTeamId(String teamId);
    @Transactional
    List<UserTeam> findByIdTeamId(String teamId);
    @Transactional
    List<UserTeam> findByIdUserId(String userId);
}
