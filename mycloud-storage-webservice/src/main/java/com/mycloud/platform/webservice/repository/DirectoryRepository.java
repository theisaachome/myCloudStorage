package com.mycloud.platform.webservice.repository;
import com.mycloud.platform.webservice.entity.DirectoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

public interface DirectoryRepository extends JpaRepository<DirectoryEntity, UUID> {
}
