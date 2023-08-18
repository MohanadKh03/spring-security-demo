package com.example.basicauth;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class HomeController {
    @GetMapping
    String hello(){
        return "Hello world";
    }
    @GetMapping("test")
    String test(){
        return "test";
    }
    @GetMapping("/only-admin")
    String admin(){
        return "Hello admin";
    }
}
