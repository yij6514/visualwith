package com.team404.visualwith.repository;

import com.team404.visualwith.entity.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TodoRepository extends JpaRepository<Todo, String> {
    List<Todo> findByTeamId(String teamId);
    List<Todo> findByUserId(String userId);
}
