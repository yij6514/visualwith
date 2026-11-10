package com.team404.visualwith.controller;

import com.team404.visualwith.dto.fileShare.FileShareRequest;
import com.team404.visualwith.service.FileShareService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;

@RestController
@RequestMapping("/api/share")
@RequiredArgsConstructor
public class ShareController {
    private final FileShareService fileShareService;

    @PostMapping("/{teamId}")
    public ResponseEntity<?> fileUpload(@RequestParam MultipartFile file, @PathVariable String teamId, Authentication auth) {
        try{
            fileShareService.fileUpload(file, teamId, auth.getName());
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Map.of("message", e.getMessage()));
        }

        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @GetMapping("/{teamId}/list")
    public String fileList(@PathVariable String teamId) {
        fileShareService.
        return null;
    }
}
