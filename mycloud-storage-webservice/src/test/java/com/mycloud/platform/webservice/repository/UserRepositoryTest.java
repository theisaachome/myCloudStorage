package com.mycloud.platform.webservice.repository;

import com.mycloud.platform.webservice.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    void testFindByUserByEmail(){
        var user = new User()
                .setEmail("example@gmail.com")
                .setUsername("example")
                .setPassword("123456");

                user.setCreatedAt(LocalDateTime.now());
               user.setLastUpdatedAt(LocalDateTime.now());
               user.setCreatedBy("user");
               user.setUpdatedBy("user");
        var savedUser=userRepository.save(user);

        var foundUser = userRepository.findByEmail(user.getEmail()).orElse(null);
        assertNotNull(foundUser);
        assertEquals(user.getEmail(),foundUser.getEmail());
    }

}
