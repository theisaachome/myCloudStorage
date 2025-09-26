package com.mycloud.platform.webservice.controller;
import com.mycloud.platform.webservice.dto.DirectoryRequest;
import com.mycloud.platform.webservice.dto.DirectoryResponse;
import com.mycloud.platform.webservice.service.DirectoryService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/directories")
public class DirectoryRestController {

    private final DirectoryService directoryService;

    public DirectoryRestController(DirectoryService directoryService) {
        this.directoryService = directoryService;
    }

    @PostMapping
    public ResponseEntity<DirectoryResponse> createDirectory(@Valid @RequestBody DirectoryRequest dto){
        var result = directoryService.createDirectory(dto);
        return ResponseEntity.ok(result);
    }
}
