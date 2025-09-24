package com.mycloud.platform.repository;

import com.mycloud.platform.entity.DirectoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DirectoryRepository extends JpaRepository<DirectoryEntity,Long> {
}
