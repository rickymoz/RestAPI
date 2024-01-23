package com.example.demo.service;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class UserService {

    public final UserRepository repository = new UserRepository();

    public List<User> getUsers() {
        return repository.getUsers();
    }

    public User addUser(final User user) {
        return repository.addUser(user);
    }

    public User getUserById(final Long userId) {
        return repository.getUserById(userId);
    }

    public void deleteUserById(final Long userId) {
        repository.deleteUserById(userId);
    }

    public User updateUserById(final Long userId, final Map<String, String> toUpdate) {
        return repository.updateUserById(userId, toUpdate);
    }
}