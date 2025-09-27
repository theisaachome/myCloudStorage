package com.mycloud.platform.webservice.service;

import com.mycloud.platform.webservice.dto.DirectoryRequest;
import com.mycloud.platform.webservice.dto.DirectoryResponse;

import java.util.UUID;

public interface DirectoryService {
    DirectoryResponse createDirectory(DirectoryRequest dto);
    DirectoryResponse updateDirectory(UUID directoryId, DirectoryRequest dto);
    DirectoryResponse deleteDirectory(UUID id);
}
