package com.team404.visualwith.controller;

import com.team404.visualwith.dto.fileShare.FileShareRequest;
import com.team404.visualwith.service.FileShareService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Path;
import java.nio.file.Paths;

@RestController
@RequestMapping("/api/share")
@RequiredArgsConstructor
public class ShareController {
    private final FileShareService fileShareService;
    @PostMapping("/test")
    public String postTest(@RequestParam String id){
        return id;
    }

    @GetMapping("/gettest")
    public String getTest(@RequestParam String id) {
        return "get:" + id;
    }

    @PostMapping("/file/{teamId}")
    public String fileTest(@RequestParam MultipartFile file, @PathVariable String teamId, Authentication auth) {
        String basePath = System.getProperty("user.home");

        Path teampath = Paths.get(
            basePath, "visualwith", "team_" + teamId
        );
        System.out.println(teampath);
        fileShareService.fileUpload(file, teampath, auth.getName());

        return "file name : " + file.getName() +
                "\nfile contenttype : " + file.getContentType() +
                "\nfile originalname : " + file.getOriginalFilename() +
                "\nfile size : " + file.getSize();
    }

    @PostMapping("/{teamId}")
    public ResponseEntity<?> fileSave(@PathVariable String teamId, @ModelAttribute FileShareRequest request) {
        return null;
    }
}
