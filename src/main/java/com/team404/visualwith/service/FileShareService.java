package com.team404.visualwith.service;

import com.team404.visualwith.entity.ShareFile;
import com.team404.visualwith.repository.FileRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class FileShareService {
    private final FileRepository fileRepository;

    public void fileUpload(MultipartFile file, String teamId, String senderId) throws IOException{
        String basePath = System.getProperty("user.home");
        Path teamPath = Paths.get(
                basePath, "visualwith", "fileShare", "team_" + teamId
        );
        ShareFile shareFile = new ShareFile(file.getName(), teamPath.toString(), file.getContentType(), file.getSize(), senderId, LocalDateTime.now());

        Files.createDirectory(teamPath);
        teamPath = Paths.get(teamPath.toString(), file.getOriginalFilename());
        file.transferTo(teamPath);

        fileRepository.save(shareFile);
    }

    public List<ShareFile> fileList(String teamId) {
        
        return null;
    }
}
