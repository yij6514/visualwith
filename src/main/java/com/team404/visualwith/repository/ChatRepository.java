package com.team404.visualwith.repository;

import com.team404.visualwith.entity.ChatMessage;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ChatRepository extends JpaRepository<ChatMessage, Long> {
    List<ChatMessage> findByRoomIdOrderByReceivedDateAscReceivedTimeAsc(String roomId);
}
