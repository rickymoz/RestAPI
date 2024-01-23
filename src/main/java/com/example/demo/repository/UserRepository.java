package com.example.demo.repository;

import com.example.demo.entity.User;
import lombok.Getter;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class UserRepository {
    private Long count = 0L;
    @Getter
    private final List<User> users = new ArrayList<>();

    public User addUser(final User user) {
        final var newUser = User.builder()
                .id(count)
                .username(user.getUsername())
                .password(user.getPassword())
                .build();

        users.add(newUser);
        count++;
        return newUser;
    }

    public User getUserById(final Long userId) {
        return users.get(Math.toIntExact(userId));
    }

    public void deleteUserById(final Long userId) {
        users.remove(Math.toIntExact(userId));
    }

    public User updateUserById(final Long userId, final Map<String, String> toUpdate) {
        if(toUpdate.containsKey("username")) {
            users.get(Math.toIntExact(userId)).setUsername(toUpdate.get("username"));
        }
        if(toUpdate.containsKey("password")) {
            users.get(Math.toIntExact(userId)).setPassword(toUpdate.get("password"));
        }

        return users.get(Math.toIntExact(userId));
    }
}