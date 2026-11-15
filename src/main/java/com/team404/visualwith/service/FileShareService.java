package com.team404.visualwith.service;

import com.team404.visualwith.dto.fileShare.FileDownloadResponse;
import com.team404.visualwith.entity.ShareFile;
import com.team404.visualwith.repository.FileRepository;
import com.team404.visualwith.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class FileShareService {
    private final FileRepository fileRepository;
    private final String basePath = System.getProperty("user.home");

    /**
     *
     * @param file
     * @param teamId
     * @param senderId
     * @throws IOException
     */
    public void fileUpload(MultipartFile file, String teamId, String senderId) throws IOException{
        Path teamPath = Paths.get(
                basePath, "visualwith", "fileShare", "team_" + teamId
        );
        ShareFile shareFile = new ShareFile(file.getOriginalFilename(), teamPath.toString(), file.getContentType(), file.getSize(), senderId, LocalDateTime.now());

        Files.createDirectories(teamPath);
        teamPath = Paths.get(teamPath.toString(), file.getOriginalFilename());
        file.transferTo(teamPath);

        fileRepository.save(shareFile);
    }

    public List<ShareFile> fileList(String teamId) {
        Path teamPath = Paths.get(
                basePath, "visualwith", "fileShare", "team_" + teamId
        );
        List<ShareFile> list = fileRepository.findByFilePath(teamPath.toString());

        return list;
    }

    public FileDownloadResponse fileDownload(Long fileId, String userName) throws IOException{
        ShareFile file = fileRepository.findById(fileId)
                .orElseThrow(() -> new RuntimeException("파일을 찾을 수 없습니다."));

        Path path = Paths.get(file.getFilePath(), file.getFileName());

        if(!Files.exists(path)) {
            throw new FileNotFoundException("파일이 존재하지 않습니다.");
        }

        Resource resource = new UrlResource(path.toUri());

        return new FileDownloadResponse(resource, file.getFileName());
    }

    @Transactional
    public void fileRename(Long fileId, String newName) throws IOException {
        ShareFile file = fileRepository.findById(fileId)
                .orElseThrow(() -> new IOException("파일을 찾을 수 없습니다"));

        Path oldPath = Paths.get(file.getFilePath(), file.getFileName());
        Path newPath = oldPath.resolveSibling(newName);

        Files.move(oldPath, newPath);

        file.setFileName(newName);
    }

    public void fileDelete(Long fileId) throws IOException {
        ShareFile file = fileRepository.findById(fileId).orElseThrow(() -> new IOException("파일을 찾을 수 없습니다."));
        Path path = Paths.get(file.getFilePath(), file.getFileName());
        Files.delete(path);
        fileRepository.deleteById(fileId);
    }
}
