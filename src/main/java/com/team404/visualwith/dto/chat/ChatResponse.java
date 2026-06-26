package com.team404.visualwith.dto.chat;

import com.team404.visualwith.entity.ChatMessage;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@AllArgsConstructor
public class ChatResponse {
    private String roomId;
    private String sender;
    private String message;
    private LocalDate receivedDate;
    private LocalTime receivedTime;

    public ChatResponse(ChatMessage chat) {
        this.roomId = chat.getRoomId();
        this.sender = chat.getSender();
        this.message = chat.getMessage();
        this.receivedDate = chat.getReceivedDate();
        this.receivedTime = chat.getReceivedTime();
    }
}
