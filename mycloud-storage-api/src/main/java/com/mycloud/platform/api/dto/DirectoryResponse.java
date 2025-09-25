package com.mycloud.platform.api.dto;

public record DirectoryResponse(
        Long id,
        String directoryName,
        String urlPath,
        Metadata metadata
) {
}
