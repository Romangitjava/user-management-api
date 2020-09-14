package com.example.rolemanagement.service.impl;

import com.example.rolemanagement.entity.User;
import com.example.rolemanagement.exception.UserAlreadyExistsException;
import com.example.rolemanagement.exception.UserNotFoundException;
import com.example.rolemanagement.repository.UserRepository;
import com.example.rolemanagement.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUserById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("User not found"));
    }

    @Override
    public User addUser(User user) {
        if (user.getId() != null && userRepository.existsById(user.getId()))
            throw new  UserAlreadyExistsException("User already exists");

        return userRepository.save(user);
    }

    @Override
    public User editUser(Long id, User user) {
        User userFromDb = userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("User not found"));

        BeanUtils.copyProperties(user, userFromDb, "id");

        return userRepository.save(userFromDb);
    }

    @Override
    public void deleteUser(Long id) {
        if (!userRepository.existsById(id)) throw new UserNotFoundException("User not found");

        userRepository.deleteById(id);
    }
}
