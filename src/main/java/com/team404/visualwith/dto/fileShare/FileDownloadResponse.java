package com.team404.visualwith.dto.fileShare;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.core.io.Resource;

@Getter
@AllArgsConstructor
public class FileDownloadResponse {
    private Resource resource;
    private String fileName;
}
