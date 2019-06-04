package com.pawelk.javadev.controllers;

import com.pawelk.javadev.models.User;
import com.pawelk.javadev.repositories.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@CrossOrigin
public class UserController {

    UserRepository repository;

    public UserController(UserRepository repository) {
        this.repository = repository;
    }

    @RequestMapping("/user/login")
    public boolean login(@RequestBody User user) {
        return user.getEmail().equals("user") && user.getPassword().equals("password");
    }

    @GetMapping("/user")
    public List<User> all() {
        return repository.findAll();
    }

    @PostMapping("/user")
    User create(@RequestBody User newUser) {
        return repository.save(newUser);
    }

    @PutMapping("/user/{id}")
    User update(@RequestBody User newUser, @PathVariable Long id) {
        return repository.findById(id)
                .map(user -> {
                    user.setFirstname(newUser.getFirstname());
                    user.setLastname(newUser.getLastname());
                    user.setEmail(newUser.getEmail());
                    user.setStudyDirection(newUser.getStudyDirection());
                    user.setIndex(newUser.getIndex());
                    return repository.save(user);
                })
                .orElseThrow(() ->
                        new ResponseStatusException(HttpStatus.NOT_FOUND, "Entity not found"));
    }

    @PutMapping("/user/{id}/password")
    User updatePassword(@RequestBody User newUser, @PathVariable Long id) {
        return repository.findById(id)
                .map(user -> {
                    user.setPassword(newUser.getPassword());
                    return repository.save(user);
                })
                .orElseThrow(() ->
                        new ResponseStatusException(HttpStatus.NOT_FOUND, "Entity not found"));
    }

}
