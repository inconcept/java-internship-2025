package org.example.securitydemo.security;

import lombok.RequiredArgsConstructor;
import org.example.securitydemo.persistence.entity.Role;
import org.example.securitydemo.persistence.entity.User;
import org.example.securitydemo.persistence.repository.UserRepository;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        final User user = userRepository.findByEmail(username)
                .orElseThrow(() -> new BadCredentialsException("Bad Credentials"));

        if (!user.isEnabled()) {
            throw new LockedException("User is locked");
        }

        final Role role = user.getRole();

        return new org.springframework.security.core.userdetails.User(
                user.getEmail(),
                user.getPassword(),
                List.of(new SimpleGrantedAuthority(role.getName().name()))
        );
    }
}
