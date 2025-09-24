package com.mycloud.platform.dto;

public record DirectoryRequest(
        String name,
        Long parent,
        String userName
) {
}
