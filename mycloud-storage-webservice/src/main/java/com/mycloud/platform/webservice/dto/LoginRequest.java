package com.mycloud.platform.webservice.dto;

public record LoginRequest(
        String email,
        String password
) {
}
