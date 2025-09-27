package com.mycloud.platform.webservice.controller;

import com.mycloud.platform.webservice.dto.AuthResponse;
import com.mycloud.platform.webservice.dto.LoginRequest;
import com.mycloud.platform.webservice.dto.RegisterRequest;
import com.mycloud.platform.webservice.security.AuthenticationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthRestController {


    private final AuthenticationService authenticationService;

    public AuthRestController(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    @PostMapping("/register")
    public ResponseEntity<?> registration(@RequestBody RegisterRequest request){
        var result  = authenticationService.register(request);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PostMapping("/login")
    public  ResponseEntity<AuthResponse> login(@RequestBody LoginRequest request){
        var result = authenticationService.login(request);
        return new ResponseEntity<>(result,HttpStatus.OK);
    }

    @PostMapping("/refresh")
    public ResponseEntity<?> refreshToken(){
        return  ResponseEntity.ok().build();
    }
}
