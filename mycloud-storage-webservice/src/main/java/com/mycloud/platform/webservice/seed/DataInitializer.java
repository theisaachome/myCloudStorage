package com.mycloud.platform.webservice.seed;

import com.mycloud.platform.webservice.entity.Role;
import com.mycloud.platform.webservice.repository.RoleRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer  implements CommandLineRunner {
    private final RoleRepository roleRepository;

    public DataInitializer(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        createRoleIfNotExist("ROLE_ADMIN");
        createRoleIfNotExist("ROLE_USER");

    }

    private void createRoleIfNotExist(String roleName) {
        roleRepository.findByName(roleName).orElseGet(()->{
            Role role = new Role();
            role.setName(roleName);
            role.getDescription();
           return roleRepository.save(role);
        });
    }
}
