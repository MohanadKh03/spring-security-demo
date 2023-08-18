package com.example.basicauth.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import static com.example.basicauth.security.AppRoles.ADMIN;
import static com.example.basicauth.security.AppRoles.USER;


@Configuration
@EnableWebSecurity
public class AppSecurityConfiguration {

    PasswordEncoder passwordEncoder;

    public AppSecurityConfiguration(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/only-admin").hasRole(ADMIN.name())
                .anyRequest()
                .authenticated()
                .and()
                .httpBasic();
        return http.build();
    }

    @Bean
    public UserDetailsService getUserDetailsService(){
        UserDetails user1 = User.builder()
                .username("mohanad")
                .password(passwordEncoder.encode("no"))
                .roles(USER.name())
                .build();
        UserDetails user2 = User.builder()
                .username("ahmed")
                .password(passwordEncoder.encode("blabla"))
                .roles(ADMIN.name())
                .build();
        return new InMemoryUserDetailsManager(
                user1,user2
        );
    }

}
