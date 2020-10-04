package io.github.bluething.spring.security.fundamentaljwt.jwt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class JwtAuthService {

    private final UserDetailsService userDetailsService;
    private final PasswordEncoder passwordEncoder;
    private final Token token;

    @Autowired
    public JwtAuthService(UserDetailsService userDetailsService, PasswordEncoder passwordEncoder, Token token) {
        this.userDetailsService = userDetailsService;
        this.passwordEncoder = passwordEncoder;
        this.token = token;
    }

    public String getToken(AuthRequest authRequest) {
        UserDetails userDetails = userDetailsService.loadUserByUsername(authRequest.getUserName());
        if(passwordEncoder.matches(authRequest.getPassword(), userDetails.getPassword())) {
            return token.generateToken(userDetails);
        }
        throw new BadCredentialsException("Bad Credential");
    }
}
