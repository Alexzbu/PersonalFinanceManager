package com.alexzbu.personal_finance_maneger.controller;

import com.alexzbu.personal_finance_maneger.model.ErrorResponse;
import com.alexzbu.personal_finance_maneger.model.User;
import com.alexzbu.personal_finance_maneger.repository.UserRepository;
import com.alexzbu.personal_finance_maneger.security.JwtResponse;
import com.alexzbu.personal_finance_maneger.security.JwtTokenUtil;
import com.alexzbu.personal_finance_maneger.service.CustomUserDetailsService;
import com.alexzbu.personal_finance_maneger.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private CustomUserDetailsService userDetailsService;

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody User user) {
        String emailPattern = "^[^\\s@]+@[^\\s@]+\\.[^\\s@]+$";

        if (!user.getUsername().matches(emailPattern)) {
            return ResponseEntity.badRequest().body(new ErrorResponse("Invalid email format"));
        }

        if (user.getPassword() == null || user.getPassword().isEmpty()) {
            return ResponseEntity.badRequest().body(new ErrorResponse("Password is required"));
        }

        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));
            final UserDetails userDetails = userDetailsService.loadUserByUsername(user.getUsername());
            final String jwt = jwtTokenUtil.generateToken(userDetails);
            return ResponseEntity.ok(new JwtResponse(jwt));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(new ErrorResponse("Invalid username or password"));
        }
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
