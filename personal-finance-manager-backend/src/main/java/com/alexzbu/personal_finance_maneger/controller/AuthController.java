package com.alexzbu.personal_finance_maneger.controller;

import com.alexzbu.personal_finance_maneger.model.ErrorResponse;
import com.alexzbu.personal_finance_maneger.model.User;
import com.alexzbu.personal_finance_maneger.repository.UserRepository;
import com.alexzbu.personal_finance_maneger.service.CustomUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private CustomUserDetailsService userDetailsService;

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/login")
    public ResponseEntity<?> login(Authentication authentication) {
        return ResponseEntity.ok().body("User logged in successfully");
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody User user) {
        String emailPattern = "^[^\\s@]+@[^\\s@]+\\.[^\\s@]+$";
        String passwordPattern = "^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{8,}$";

        if (!user.getUsername().matches(emailPattern)) {
            return ResponseEntity.badRequest().body(new ErrorResponse("Invalid email format"));
        }

        if (!user.getPassword().matches(passwordPattern)) {
            return ResponseEntity.badRequest().body(new ErrorResponse("Password must be at least 8 characters long and contain at least one letter and one number"));
        }

        if (userDetailsService.userExists(user.getUsername())) {
            return ResponseEntity.badRequest().body(new ErrorResponse("Username is already taken"));
        }

        userDetailsService.save(user);
        System.out.println(userRepository.findAll());
        return ResponseEntity.ok("User registered successfully");
    }
}
