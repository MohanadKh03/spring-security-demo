package com.example.jwtdemo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
public class HomeController {
    @GetMapping
    public ResponseEntity<Object> index(Principal principal){
        return new ResponseEntity<>("Hello world! from " + principal.getName(), HttpStatus.OK);
    }
}
