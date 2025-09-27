package com.mycloud.platform.webservice.security;

import com.mycloud.platform.webservice.dto.AuthResponse;
import com.mycloud.platform.webservice.dto.LoginRequest;
import com.mycloud.platform.webservice.dto.RegisterRequest;
import com.mycloud.platform.webservice.entity.Role;
import com.mycloud.platform.webservice.entity.User;
import com.mycloud.platform.webservice.exception.AppApiException;
import com.mycloud.platform.webservice.repository.RoleRepository;
import com.mycloud.platform.webservice.repository.UserRepository;
import com.mycloud.platform.webservice.security.jwt.JwtTokenProvider;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {

    private final AuthenticationManager authenticationManager;
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final JwtTokenProvider jwtTokenProvider;

    public AuthenticationServiceImpl(AuthenticationManager authenticationManager,
                                     UserRepository userRepository, RoleRepository roleRepository,
                                     BCryptPasswordEncoder bCryptPasswordEncoder, JwtTokenProvider jwtTokenProvider) {
        this.authenticationManager = authenticationManager;
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
        this.jwtTokenProvider = jwtTokenProvider;
    }
    @Override
    public String register(RegisterRequest request){
        // find user by -email
        var existingUser = userRepository.findByEmail(request.email())
                .orElse(null);
        var role =roleRepository.findByName("ROLE_USER").orElseThrow(()->new EntityNotFoundException("Role not found"));
        var userRoles = new HashSet<Role>();
        userRoles.add(role);
        if(existingUser != null){
            throw new AppApiException(HttpStatus.BAD_REQUEST,"User Already existed!");
        }
        User user = new User();
        user.setUsername(request.username());
        user.setPassword(bCryptPasswordEncoder.encode(request.password()));
        user.setEmail(request.email());
        user.setRoles(userRoles);
        //Todo create home-directory for newly registered user.

        userRepository.save(user);
        return "User registration successfully.";
    }
    @Override
    public AuthResponse login(LoginRequest request){
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.email(),request.password()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        var accessToken= jwtTokenProvider.generateToken(authentication);

         return new AuthResponse(
                accessToken,
                 "sample-refreshToken",
                 "Bearer",
                 1L,
                 "user-id",
                 "username",
                 "userEmail");

    }
}
