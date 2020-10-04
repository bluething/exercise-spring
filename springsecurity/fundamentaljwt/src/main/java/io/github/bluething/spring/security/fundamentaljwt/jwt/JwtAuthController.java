package io.github.bluething.spring.security.fundamentaljwt.jwt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class JwtAuthController {

    private final JwtAuthService jwtAuthService;

    @Autowired
    public JwtAuthController(JwtAuthService jwtAuthService) {
        this.jwtAuthService = jwtAuthService;
    }

    @PostMapping(path = "/api/auth/sigin", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity authenticateUser(@Valid @RequestBody AuthRequest authRequest) {
        String token = jwtAuthService.getToken(authRequest);
        return ResponseEntity.ok()
                .header("Authorization", token)
                .build();
    }

}
