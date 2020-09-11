package com.example.rolemanagement.controller;

import com.example.rolemanagement.entity.User;
import com.example.rolemanagement.entity.Views;
import com.example.rolemanagement.repository.UserRepository;
import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.beans.BeanUtils;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("users")
public class UserController {

    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping
    @JsonView(Views.UserEntity.class)
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @GetMapping(value = "{id}")
    public User getOne(@PathVariable("id") Long id) {
        return userRepository.findById(id)
              .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public User add(@RequestBody @Valid  User user) {
        return userRepository.save(user);
    }

    @PutMapping(value = "{id}")
    public User edit(@PathVariable("id") User userFromDb, @RequestBody @Valid  User user) {
        BeanUtils.copyProperties(user, userFromDb, "id");
        return userRepository.save(userFromDb);
    }

    @DeleteMapping(value = "{id}")
    public void delete(@PathVariable("id") User user) {
        if (user == null) throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        userRepository.delete(user);
    }
}
