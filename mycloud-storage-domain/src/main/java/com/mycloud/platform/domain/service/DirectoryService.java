package com.mycloud.platform.domain.service;

import com.mycloud.platform.domain.entity.DirectoryEntity;
import com.mycloud.platform.domain.exception.DirectoryNotFoundException;
import com.mycloud.platform.domain.repository.DirectoryRepository;
import org.springframework.stereotype.Service;

import java.nio.file.Path;
import java.util.List;
import java.util.Objects;

@Service
public class DirectoryService {

    private final DirectoryRepository directoryRepository;
    private final FileSystemStorageProvider  fileSystemStorageProvider;

    public DirectoryService(DirectoryRepository directoryRepository, FileSystemStorageProvider fileSystemStorageProvider) {
        this.directoryRepository = directoryRepository;
        this.fileSystemStorageProvider = fileSystemStorageProvider;
    }

    public DirectoryEntity createDirectory(DirectoryEntity directoryEntity) {
       Objects.requireNonNull(directoryEntity,"Directory can not be null.");

       // if not parent-id in the request -> new directory will be created under user home directory
        // /storage/users/{john}/{directory-name}

        // if parent-id is valid -> get the parent's url from database and append {directory-name}

       Path createdDirectory= fileSystemStorageProvider.createDirectory(directoryEntity.getName());
       directoryEntity.setPath(createdDirectory.toString());

        return directoryRepository.save(directoryEntity);
    }
    public  void deleteDirectory(Long directoryId) {
        var directoryEntity = directoryRepository.findById(directoryId)
                .orElseThrow(()->new DirectoryNotFoundException("No such Directory"));
        fileSystemStorageProvider.deleteDirectory(directoryEntity.getPath(),false);
    }
    public DirectoryEntity findDirectoryById(Long directoryId) {
        return directoryRepository.findById(directoryId).orElseThrow(()->new DirectoryNotFoundException("No such Directory"));
    }

    public List<DirectoryEntity> findAllDirectory() {
        return directoryRepository.findAll();
    }

}
