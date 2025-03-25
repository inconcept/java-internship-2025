package com.springbootdemo.springbootdemo.persistence;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Repository
public class UserRepository {

    private final List<User> users = new ArrayList<>();
    private long count = 1L;

    public List<User> getAllUsers() {
        return Collections.unmodifiableList(users);
    }

    public User create(User user) {
        user.setId(count++);
        users.add(user);
        return user;
    }

    public User getUser(Long id) {
        for (User user : users) {
            if (user.getId().equals(id)) {
                return user;
            }
        }
        return null;
    }

    public void delete(User user) {
        users.remove(user);
    }
}
