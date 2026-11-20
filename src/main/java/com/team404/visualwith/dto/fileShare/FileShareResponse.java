package com.team404.visualwith.dto.fileShare;

import com.team404.visualwith.entity.ShareFile;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
public class FileShareResponse {
    private Long id;
    private String fileName;
    private String filePath;
    private String fileType;
    private Long fileSize;
    private String senderId;
    private LocalDateTime createdAt;

    public FileShareResponse(ShareFile shareFile) {
        this.id = shareFile.getFileId();
        this.filePath = shareFile.getFilePath();
        this.fileType = shareFile.getFileType();
        this.fileSize = shareFile.getFileSize();
        this.fileName = shareFile.getFileName();
        this.senderId = shareFile.getSenderId();
        this.createdAt = shareFile.getCreatedAt();
    }
}
