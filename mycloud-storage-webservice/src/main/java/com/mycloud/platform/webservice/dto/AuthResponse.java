package com.mycloud.platform.webservice.dto;

public record AuthResponse(
        String accessToken,
        String refreshToken,
        String tokenType,
        Long expiresIn,

        String userId,
        String username,
        String email){}
