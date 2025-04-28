package org.example.securitydemo.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.securitydemo.security.dto.LoginRequestDto;
import org.example.securitydemo.security.dto.LoginResponse;
import org.example.securitydemo.service.AuthenticationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthenticationController {

    private final AuthenticationService authenticationService;

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@Valid @RequestBody LoginRequestDto loginRequestDto) {
        return ResponseEntity.ok(authenticationService.authenticate(loginRequestDto));
    }
}
