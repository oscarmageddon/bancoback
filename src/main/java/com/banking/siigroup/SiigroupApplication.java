package com.banking.siigroup;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.banking.siigroup.entity.Role;
import com.banking.siigroup.repository.RoleRepository;

@SpringBootApplication
public class SiigroupApplication {

	public static void main(String[] args) {
		SpringApplication.run(SiigroupApplication.class, args);
	}


    @Bean
    CommandLineRunner init(RoleRepository roleRepository) {

        return args -> {

            Role adminRole = roleRepository.findByName("ADMIN");
            if (adminRole == null) {
                Role newAdminRole = new Role();
                newAdminRole.setName("ADMIN");
                roleRepository.save(newAdminRole);
            }

            Role executiveRole = roleRepository.findByName("EXECUTIVE");
            if (executiveRole == null) {
                Role newUserRole = new Role();
                newUserRole.setName("EXECUTIVE");
                roleRepository.save(newUserRole);
            }
        };

    }
	
}
