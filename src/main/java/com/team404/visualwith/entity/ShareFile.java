package com.team404.visualwith.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@AllArgsConstructor
@Table(name="file")
public class ShareFile {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long fileId;
    private String teamId;
    private String fileName;
    private String filePath;
    private String fileType;
    private Long fileSize;
    private String senderId;
    private LocalDateTime createdAt;
}
