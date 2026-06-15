package com.team404.visualwith.service;

import com.team404.visualwith.dto.ChatMessage;
import com.team404.visualwith.repository.ChatRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ChatService {
    private final ChatRepository chatRepository;

    public void chatSave(ChatMessage chatMessage) {
        chatRepository.save(chatMessage);
    }
}
