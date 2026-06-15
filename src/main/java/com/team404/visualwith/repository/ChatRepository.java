package com.team404.visualwith.repository;

import com.team404.visualwith.dto.ChatMessage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChatRepository extends JpaRepository<ChatMessage, Long> {
}
