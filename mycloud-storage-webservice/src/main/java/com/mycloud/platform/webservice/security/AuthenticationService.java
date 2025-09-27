package com.mycloud.platform.webservice.security;

import com.mycloud.platform.webservice.dto.AuthResponse;
import com.mycloud.platform.webservice.dto.LoginRequest;
import com.mycloud.platform.webservice.dto.RegisterRequest;

public interface AuthenticationService {

    AuthResponse login(LoginRequest request);
    String register(RegisterRequest request);
}
