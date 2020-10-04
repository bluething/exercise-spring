package io.github.bluething.spring.security.fundamentaljwt.jwt;

import lombok.Getter;

import javax.validation.constraints.NotBlank;

@Getter
public class AuthRequest {

    @NotBlank
    private final String userName;
    @NotBlank
    private final String password;

    public AuthRequest(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }
}
