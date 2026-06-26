package com.team404.visualwith.entity;

import com.team404.visualwith.dto.chat.ChatReceived;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class ChatMessage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String roomId;
    private String sender;
    private String message;
    private LocalDate receivedDate;
    private LocalTime receivedTime;

    public ChatMessage(ChatReceived chat) {
        this.roomId = chat.getId();
        this.sender = chat.getName();
        this.message = chat.getMessage();
        this.receivedDate = LocalDate.now();
        this.receivedTime = LocalTime.now().withSecond(0).withNano(0);
    }
}
