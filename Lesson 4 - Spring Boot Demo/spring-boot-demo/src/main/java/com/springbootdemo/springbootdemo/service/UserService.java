package com.springbootdemo.springbootdemo.service;

import com.springbootdemo.springbootdemo.persistence.User;
import com.springbootdemo.springbootdemo.persistence.UserRepository;
import com.springbootdemo.springbootdemo.service.dto.UserDto;
import com.springbootdemo.springbootdemo.service.exception.UserNotFoundException;
import com.springbootdemo.springbootdemo.service.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Autowired
    public UserService(UserRepository userRepository,
                       UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    public List<UserDto> getAllUsers(String firstName) {
        final List<UserDto> filteredUsers = new ArrayList<>();

        final List<User> allUsers = userRepository.getAllUsers();

        if (!StringUtils.hasLength(firstName)) {
            return userMapper.mapToDtos(allUsers);
        }

        for (User user : allUsers) {
            if (user.getFirstName().equals(firstName)) {
                filteredUsers.add(userMapper.mapToDto(user));
            }
        }

        return filteredUsers;
    }

    public UserDto createUser(UserDto userDto) {
        User user = userRepository.create(userMapper.mapDtoToUser(userDto));
        return userMapper.mapToDto(user);
    }

    public UserDto getUser(Long id) {
        User user = userRepository.getUser(id);

        if (user == null) {
            throw new UserNotFoundException("User with id %s not found".formatted(id));
        }

        return userMapper.mapToDto(user);
    }

    public void deleteUser(Long id) {
        User user = userRepository.getUser(id);

        if (user == null) {
            throw new UserNotFoundException("User with id %s not found".formatted(id));
        }

        userRepository.delete(user);
    }

    public UserDto update(Long id, UserDto userDto) {
        User user = userRepository.getUser(id);

        if (user == null) {
            throw new UserNotFoundException("User with id %s not found".formatted(id));
        }

        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());
        user.setEmail(userDto.getEmail());

        return userMapper.mapToDto(user);
    }
}
