package com.team404.visualwith.repository;

import com.team404.visualwith.entity.ShareFile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FileRepository extends JpaRepository<ShareFile, Long> {
}
