package com.example.jpaauth;

import com.example.jpaauth.model.Account;
import com.example.jpaauth.repository.AccountRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class JpaAuthApplication {

    public static void main(String[] args) {
        SpringApplication.run(JpaAuthApplication.class, args);
    }

}
