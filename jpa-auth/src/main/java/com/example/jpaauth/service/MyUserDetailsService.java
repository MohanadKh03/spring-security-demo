package com.example.jpaauth.service;

import com.example.jpaauth.model.MyUserDetails;
import com.example.jpaauth.repository.AccountRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService implements UserDetailsService {
    private final AccountRepository accountRepository;
    public MyUserDetailsService(AccountRepository accountRepository){
        this.accountRepository = accountRepository;
    }
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return accountRepository.findById(username)
                .map(MyUserDetails::new)
                .orElseThrow(() -> new UsernameNotFoundException("User " + username + " not found!"));
    }
}
