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

@Service
@RequiredArgsConstructor
public class FileShareService {
    private final FileRepository fileRepository;

    public void fileUpload(MultipartFile file, Path filePath, String senderId) {
        ShareFile shareFile = new ShareFile(file.getName(), filePath.toString(), file.getContentType(), file.getSize(), senderId, LocalDateTime.now());
        
        try {
            Files.createDirectory(filePath);
            filePath = Paths.get(filePath.toString(), file.getOriginalFilename());
            file.transferTo(filePath);
        }
        catch (IOException e) {
            System.out.println(e.getMessage());
        }
        catch (IllegalStateException e) {
            System.out.println(e.getMessage());
        }

        fileRepository.save(shareFile);
    }

}
