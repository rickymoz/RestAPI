package com.example.demo.controller;

import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService service;

    @GetMapping
    public List<User> getUsers() {
        return service.getUsers();
    }

    @PostMapping
    public ResponseEntity<User> addUser(@RequestBody final User user) {
        return ResponseEntity.status(201)
                .body(service.addUser(user));
    }

    @GetMapping("/{userId}")
    public User getUserById(@PathVariable final Long userId) {
        return service.getUserById(userId);
    }

    @DeleteMapping("/{userId}")
    public void deleteUserById(@PathVariable final Long userId) {
        service.deleteUserById(userId);
    }

    @PatchMapping("/{userId}")
    public User updateUserById(@PathVariable Long userId, @RequestBody Map<String, String> toUpdate) {
        return service.updateUserById(userId, toUpdate);
    }
}
