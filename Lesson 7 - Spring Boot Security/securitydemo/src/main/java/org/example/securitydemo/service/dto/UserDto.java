package org.example.securitydemo.service.dto;

import lombok.Getter;
import lombok.Setter;
import org.example.securitydemo.persistence.entity.User;

@Getter
@Setter
public class UserDto {

    private Long id;
    private String firstname;
    private String lastname;
    private String email;
    private Long createdAt;
    private Long updatedAt;

    public static UserDto toDto(User user) {
        final UserDto userDto = new UserDto();

        userDto.setId(user.getId());
        userDto.setFirstname(user.getFirstname());
        userDto.setLastname(user.getLastname());
        userDto.setEmail(user.getEmail());
        userDto.setCreatedAt(user.getCreatedAt().toEpochMilli());
        userDto.setUpdatedAt(user.getUpdatedAt().toEpochMilli());

        return userDto;
    }
}
