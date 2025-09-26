package com.mycloud.platform.webservice.service;

import com.mycloud.platform.webservice.dto.DirectoryRequest;
import com.mycloud.platform.webservice.dto.DirectoryResponse;

public interface DirectoryService {
    DirectoryResponse createDirectory(DirectoryRequest dto);
    DirectoryResponse updateDirectory(Long directoryId,DirectoryRequest dto);
    DirectoryResponse deleteDirectory(Long id);
}
