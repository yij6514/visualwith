package com.team404.visualwith.entity;

import com.team404.visualwith.dto.chat.ChatReceived;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="message")
public class ChatMessage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="message_id")
    private Long id;

    @Column(nullable = false,name="chat_id")
    private int roomId;
    @Column(name="sender_id")
    private int sender;
    @Column(name="content")
    private String message;
    @Column(name="created_at")
    private LocalDateTime receivedAt;

    public ChatMessage(ChatReceived chat) {
        this.roomId = Integer.parseInt(chat.getId());
        this.sender = Integer.parseInt(chat.getName());
        this.message = chat.getMessage();
        this.receivedAt = LocalDateTime.now();
    }
}
