package com.example.rolemanagement.service;

import com.example.rolemanagement.entity.User;

import java.util.List;

public interface UserService {

    List<User> getAllUsers();
    User getUserById(Long id);
    User addUser(User user);
    User editUser(Long id, User user);
    void deleteUser(Long id);

}
