package org.example.securitydemo.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.securitydemo.service.UserService;
import org.example.securitydemo.service.dto.UserDto;
import org.example.securitydemo.service.dto.UserRegistrationDto;
import org.example.securitydemo.service.dto.UserUpdateDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    @PostMapping
    public ResponseEntity<UserDto> createUser(@Valid @RequestBody UserRegistrationDto userRegistrationDto) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(userService.createUser(userRegistrationDto));
    }

    @GetMapping
    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN')")
    public ResponseEntity<List<UserDto>> getAllUsers() {
        return ResponseEntity.ok(userService.getAllUsers());
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDto> getById(@PathVariable Long id) {
        return ResponseEntity.ok(userService.getById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserDto> updateUser(@PathVariable Long id, @Valid @RequestBody UserUpdateDto updateDto) {
        return ResponseEntity.ok(userService.updateUser(id, updateDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }
}
