package com.mycloud.platform.api;

import com.mycloud.platform.entity.DirectoryEntity;
import com.mycloud.platform.service.FileService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/directories")
public class DirectoryApi {

    // get all user-home both directories and files
    private final FileService fileService;

    public DirectoryApi(FileService fileService) {
        this.fileService = fileService;
    }

    @PostMapping
    public ResponseEntity<DirectoryEntity> createDirectory(@RequestBody  DirectoryEntity directoryEntity) {
        var result = fileService.createDirectory(directoryEntity);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @DeleteMapping("/{directory_id}")
    public ResponseEntity<?> deleteDirectory(@PathVariable("directory_id") Long directory_id) {
        fileService.deleteDirectory(directory_id);
        return new ResponseEntity<>("delete successful",HttpStatus.OK);
    }
}
