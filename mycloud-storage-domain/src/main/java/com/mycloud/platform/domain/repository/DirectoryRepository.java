package com.mycloud.platform.domain.repository;

import com.mycloud.platform.domain.entity.DirectoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DirectoryRepository extends JpaRepository<DirectoryEntity,Long> {
}
