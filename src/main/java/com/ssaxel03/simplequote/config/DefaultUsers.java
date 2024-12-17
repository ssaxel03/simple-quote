package com.ssaxel03.simplequote.config;

import com.ssaxel03.simplequote.daos.UserDao;
import com.ssaxel03.simplequote.model.Role;
import com.ssaxel03.simplequote.model.User;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;

public class DefaultUsers {

    @Bean
    CommandLineRunner initDatabase(UserDao repository, PasswordEncoder encoder) {
        return args -> {

            User admin = new User();
            admin.setUsername("admin");
            admin.setPassword(encoder.encode("admin"));
            admin.setRole(Role.ROLE_ADMIN.getRole());

            repository.saveOrUpdate(admin);
        };
    }

}
