package com.alexzbu.personal_finance_maneger.security;

public class JwtResponse {

    private final String jwtToken;

    public JwtResponse(String jwtToken) {
        this.jwtToken = jwtToken;
    }

    public String getToken() {
        return jwtToken;
    }
}
