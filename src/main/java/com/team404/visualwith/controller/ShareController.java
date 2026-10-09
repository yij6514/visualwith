package com.team404.visualwith.controller;

import com.team404.visualwith.dto.FileShareRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/share")
public class ShareController {
    @PostMapping("/test")
    public String postTest(@RequestParam String id){
        return id;
    }

    @GetMapping("/gettest")
    public String getTest(@RequestParam String id) {
        return "get:" + id;
    }

    @PostMapping("/file")
    public String fileTest(@RequestParam MultipartFile file) {

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
