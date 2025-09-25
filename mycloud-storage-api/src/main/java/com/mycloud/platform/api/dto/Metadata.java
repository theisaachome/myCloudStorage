package com.mycloud.platform.api.dto;

import java.time.LocalDateTime;

public record Metadata(
        LocalDateTime createdAt,
        LocalDateTime lastUpdated
) {
}
