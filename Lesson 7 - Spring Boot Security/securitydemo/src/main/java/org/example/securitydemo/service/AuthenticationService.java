package org.example.securitydemo.service;

import lombok.RequiredArgsConstructor;
import org.example.securitydemo.security.dto.LoginRequestDto;
import org.example.securitydemo.security.dto.LoginResponse;
import org.example.securitydemo.security.util.JwtUtil;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final AuthenticationManager authenticationManager;
    private final JwtUtil jwtUtil;

    public LoginResponse authenticate(LoginRequestDto loginRequest) {
        final Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginRequest.getUsername(),
                        loginRequest.getPassword()
                )
        );

        final UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        final String accessToken = jwtUtil.generateAccessToken(userDetails);
        final String refreshToken = jwtUtil.generateRefreshToken(userDetails);

        return LoginResponse.builder()
                .withUsername(userDetails.getUsername())
                .withAccessToken(accessToken)
                .withRefreshToken(refreshToken)
                .build();
    }
}
