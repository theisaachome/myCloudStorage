package com.mycloud.platform.api.dto;

public record DirectoryRequest(
        String directoryName,
        Long parent,
        String username
) {
}
