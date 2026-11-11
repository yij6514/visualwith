package com.team404.visualwith.repository;

import com.team404.visualwith.entity.ShareFile;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FileRepository extends JpaRepository<ShareFile, Long> {
    List<ShareFile> findByFilePath(String filePath);
}
