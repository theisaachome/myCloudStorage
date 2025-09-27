package com.mycloud.platform.webservice.dto;

public record RegisterRequest(
        String username,
        String email,
        String password
) {
}
