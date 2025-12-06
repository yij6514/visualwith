package com.team404.visualwith.repository;

import com.team404.visualwith.entity.UserTeam;
import com.team404.visualwith.entity.UserTeamId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserTeamRepository extends JpaRepository<UserTeam, UserTeamId> {
}
