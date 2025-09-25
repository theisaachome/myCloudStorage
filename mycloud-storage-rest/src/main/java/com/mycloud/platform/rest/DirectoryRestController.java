package com.mycloud.platform.rest;

import com.mycloud.platform.api.dto.DirectoryRequest;
import com.mycloud.platform.api.dto.DirectoryResponse;
import com.mycloud.platform.domain.repository.DirectoryRepository;
import com.mycloud.platform.mapper.DirectoryMapper;
import com.mycloud.platform.domain.service.DirectoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/directories")
public class DirectoryRestController {

    // get all user-home both directories and files
    private final DirectoryService directoryService;
    private final DirectoryRepository directoryRepository;
    private final DirectoryMapper directoryMapper;

    public DirectoryRestController(DirectoryService directoryService, DirectoryRepository directoryRepository, DirectoryMapper directoryMapper) {
        this.directoryService = directoryService;
        this.directoryRepository = directoryRepository;
        this.directoryMapper = directoryMapper;
    }

    @PostMapping
    public ResponseEntity<DirectoryResponse> createDirectory(@RequestBody DirectoryRequest request) {
        var parent = request.parent() != null ? directoryRepository.findById(request.parent()).orElse(null) : null;
        var entity = directoryMapper.mapToEntity(request);
        entity.setParent(parent);
        var result = directoryService.createDirectory(entity);
        return new ResponseEntity<>(directoryMapper.mapToRes(result), HttpStatus.OK);
    }

    @DeleteMapping("/{directory_id}")
    public ResponseEntity<?> deleteDirectory(@PathVariable("directory_id") Long directory_id) {
        directoryService.deleteDirectory(directory_id);
        return new ResponseEntity<>("delete successful",HttpStatus.OK);
    }
}
