package com.springbootdemo.springbootdemo.service.mapper;

import com.springbootdemo.springbootdemo.persistence.User;
import com.springbootdemo.springbootdemo.service.dto.UserDto;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserMapper {

    public UserDto mapToDto(User user) {
        if (user == null) {
            return null;
        }

        return new UserDto(
                user.getId(),
                user.getFirstName(),
                user.getLastName(),
                user.getEmail()
        );
    }

    public List<UserDto> mapToDtos(List<User> users) {
        List<UserDto> dtos = new ArrayList<>();

        for (User user : users) {
            dtos.add(mapToDto(user));
        }

        return dtos;
    }

    public User mapDtoToUser(UserDto dto) {
        return new User(dto.getFirstName(), dto.getLastName(), dto.getEmail());
    }
}
