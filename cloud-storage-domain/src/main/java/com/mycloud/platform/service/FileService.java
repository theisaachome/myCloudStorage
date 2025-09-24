package com.mycloud.platform.service;

import com.mycloud.platform.entity.DirectoryEntity;
import com.mycloud.platform.exception.DirectoryNotFoundException;
import com.mycloud.platform.repository.DirectoryRepository;
import org.springframework.stereotype.Service;

import java.nio.file.Path;

@Service
public class FileService {

    private final DirectoryRepository directoryRepository;
    private final FileSystemStorageProvider  fileSystemStorageProvider;

    public FileService(DirectoryRepository directoryRepository, FileSystemStorageProvider fileSystemStorageProvider) {
        this.directoryRepository = directoryRepository;
        this.fileSystemStorageProvider = fileSystemStorageProvider;
    }

    public DirectoryEntity createDirectory(DirectoryEntity directoryEntity) {
        // build path
        String path = "";
        if(directoryEntity.getParent().getId() != null) {
          var pareth=  directoryRepository.findById(directoryEntity.getParent().getId()).orElse(null);
          if(pareth != null) {
              path = pareth.getPath();
              directoryEntity.setParent(pareth);
          }
        }else{
            // get directory name and create
            path = directoryEntity.getName();
        }
       Path createdDirectory= fileSystemStorageProvider.createDirectory(path);
       directoryEntity.setPath(createdDirectory.toString());

        return directoryRepository.save(directoryEntity);
    }
    public  void deleteDirectory(Long directoryId) {
        var directoryEntity = directoryRepository.findById(directoryId)
                .orElseThrow(()->new DirectoryNotFoundException("No such Directory"));
        fileSystemStorageProvider.deleteDirectory(directoryEntity.getPath(),false);
    }
}
