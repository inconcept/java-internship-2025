package org.example.securitydemo.security.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder(setterPrefix = "with")
public class LoginResponse {

    private String username;
    private String accessToken;
    private String refreshToken;
}
