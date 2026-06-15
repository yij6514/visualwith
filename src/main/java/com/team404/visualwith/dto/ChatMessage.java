package com.team404.visualwith.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class ChatMessage {
    @Id
    private Long roomId;
    private String sender;
    private String message;
}
