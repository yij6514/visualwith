package com.team404.visualwith.service;

import com.team404.visualwith.dto.chat.ChatReceived;
import com.team404.visualwith.dto.chat.ChatResponse;
import com.team404.visualwith.entity.ChatMessage;
import com.team404.visualwith.repository.ChatRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ChatService {
    private final ChatRepository chatRepository;

    public void chatSave(ChatReceived chatMessage) {
        ChatMessage chat = new ChatMessage(chatMessage);
        chatRepository.save(chat);
    }

    public List<ChatResponse> chatLoad(String roomId) {
        List<ChatMessage> list = chatRepository.findByRoomIdOrderByReceivedDateAscReceivedTimeAsc(roomId);
        List<ChatResponse> responseList = new ArrayList<>();
        for(ChatMessage chat : list) {
            responseList.add(new ChatResponse(chat));
        }
        return responseList;
    }
}
