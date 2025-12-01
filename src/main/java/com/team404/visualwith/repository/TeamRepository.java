package com.team404.visualwith.repository;

import com.team404.visualwith.entity.Team;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeamRepository extends JpaRepository<Team, Long> {
}
