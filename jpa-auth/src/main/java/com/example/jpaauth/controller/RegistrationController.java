package com.example.jpaauth.controller;

import com.example.jpaauth.model.Account;
import com.example.jpaauth.service.RegistrationService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/register")
public class RegistrationController {

    private final RegistrationService registrationService;
    public RegistrationController(RegistrationService registrationService){
        this.registrationService = registrationService;
    }
    @PostMapping("/test")
    public ResponseEntity<Object> test(){
        return new ResponseEntity<>("From register",HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<Object> register(@RequestBody @Valid Account account){
        registrationService.registerAccount(account);
        return new ResponseEntity<>("Your account has been created successfully!",HttpStatus.OK);
    }

}
