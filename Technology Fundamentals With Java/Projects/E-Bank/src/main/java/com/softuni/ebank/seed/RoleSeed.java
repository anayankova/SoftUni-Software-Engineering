package com.softuni.ebank.seed;

import com.softuni.ebank.entities.Role;
import com.softuni.ebank.repositories.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;
import java.util.Arrays;

@Service
@Transactional
public class RoleSeed {

    private final RoleRepository roleRepository;

    @Autowired
    public RoleSeed(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @PostConstruct
    public void seedRoles() {
        if (this.roleRepository.count() == 0) {
            Role userRole = new Role();
            userRole.setAuthority("USER");
            Role adminRole = new Role();
            adminRole.setAuthority("ADMIN");
            this.roleRepository.saveAll(Arrays.asList(userRole, adminRole));
        }
    }
}
