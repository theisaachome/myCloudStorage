package com.mycloud.platform.webservice.security;

import com.mycloud.platform.webservice.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    public CustomUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // find in a database
        var user = userRepository.findByEmail(username);
        if(user.isPresent()){
            var currentUser = user.get();
            return new SecurityUser(currentUser);
        }
        return null;
    }
}
