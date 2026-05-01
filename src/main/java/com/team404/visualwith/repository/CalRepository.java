package com.team404.visualwith.repository;

import com.team404.visualwith.entity.Calendar;
import com.team404.visualwith.entity.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CalRepository extends JpaRepository<Calendar, Long> {
    List<Todo> findByTeamId(String teamId);
    List<Todo> findByUserId(String userId);
}
