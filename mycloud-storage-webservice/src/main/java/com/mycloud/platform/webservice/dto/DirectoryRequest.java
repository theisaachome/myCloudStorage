package com.mycloud.platform.webservice.dto;

import jakarta.validation.constraints.NotEmpty;

import java.util.UUID;

public record DirectoryRequest(
        @NotEmpty(message = "Directory-Name is required")
        String name,
        UUID parentId,
        @NotEmpty(message = "mimetype is required")
        String mimeType
) {
}
