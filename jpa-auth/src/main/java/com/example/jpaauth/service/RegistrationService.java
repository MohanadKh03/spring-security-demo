package com.example.jpaauth.service;

import com.example.jpaauth.exception.UsernameAlreadyTakenException;
import com.example.jpaauth.model.Account;
import com.example.jpaauth.repository.AccountRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class RegistrationService {
    private final AccountRepository accountRepository;

    private final PasswordEncoder passwordEncoder;
    public RegistrationService(AccountRepository accountRepository,PasswordEncoder passwordEncoder){
        this.accountRepository = accountRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public void registerAccount(Account account){
        if(accountRepository.findById(account.getUsername()).isPresent())
            throw new UsernameAlreadyTakenException();
        account.setPassword(passwordEncoder.encode(account.getPassword()));
        account.setRole("ROLE_USER");
        accountRepository.save(account);
    }

}
