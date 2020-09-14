package com.example.rolemanagement.controller;

import com.example.rolemanagement.entity.User;
import com.example.rolemanagement.entity.Views;
import com.example.rolemanagement.service.impl.UserServiceImpl;
import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("users")
public class UserController {

    private final UserServiceImpl userService;

    public UserController(UserServiceImpl userService) {
        this.userService = userService;
    }

    @GetMapping
    @JsonView(Views.UserEntity.class)
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping(value = "{id}")
    public User getUser(@PathVariable("id") Long id) {
        return userService.getUserById(id);
    }

    @PostMapping
    public User addUser(@RequestBody @Valid  User user) {
        return userService.addUser(user);
    }

    @PutMapping(value = "{id}")
    public User editUser(@PathVariable("id") Long id, @RequestBody @Valid  User user) {
       return userService.editUser(id, user);
    }

    @DeleteMapping(value = "{id}")
    public void deleteUser(@PathVariable("id") Long id) {
        userService.deleteUser(id);
    }
}
