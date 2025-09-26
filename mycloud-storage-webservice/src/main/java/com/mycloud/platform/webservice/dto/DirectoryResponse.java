package com.mycloud.platform.webservice.dto;

import java.util.UUID;

public record DirectoryResponse(
        UUID id,
        String name,
        String status,
        Metadata metadata
) {
}
