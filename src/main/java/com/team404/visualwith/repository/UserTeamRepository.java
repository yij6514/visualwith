package com.team404.visualwith.repository;

import com.team404.visualwith.entity.Team;
import com.team404.visualwith.entity.User;
import com.team404.visualwith.entity.UserTeam;
import com.team404.visualwith.entity.UserTeamId;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserTeamRepository extends JpaRepository<UserTeam, UserTeamId> {
    @Transactional
    void deleteByIdTeamId(String teamId);

    //Optional<UserTeam> findByUserAndTeamId(UserTeamId userTeamId);
}
