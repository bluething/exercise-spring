package io.github.bluething.spring.security.fundamentaljwt.jwt;

import org.springframework.security.core.userdetails.UserDetails;

public interface Token {
    public String generateToken(UserDetails userDetails);
    public boolean isTokenValid(String token);
}
