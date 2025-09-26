package com.mycloud.platform.webservice.dto;

import java.time.LocalDateTime;

public record Metadata(
        String createdBy,
        String updateBy,
        LocalDateTime createdAt,
        LocalDateTime lastUpdatedAt
) {
}
