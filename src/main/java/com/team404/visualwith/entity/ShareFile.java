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

    @Column(name="file_name")
    private String fileName;

    @Column(name="file_path")
    private String filePath;

    @Column(name="file_type")
    private String fileType;

    @Column(name="file_size")
    private Long fileSize;

    @Column(name="sender_id")
    private String senderId;

    @Column(name="created_at")
    private LocalDateTime createdAt;

    public ShareFile(String fileName, String filePath, String fileType, Long fileSize, String senderId, LocalDateTime createdAt) {
        this.fileName = fileName;
        this.filePath = filePath;
        this.fileType = fileType;
        this.fileSize = fileSize;
        this.senderId = senderId;
        this.createdAt = createdAt;
    }
}
