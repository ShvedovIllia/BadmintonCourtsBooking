package com.badminton.service.impl;

import com.badminton.domain.UserDTO;
import com.badminton.repository.UserRepository;
import com.badminton.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    public void addUser(UserDTO userDTO) {
        userRepository.save();
    }

    public List<UserDTO> getAllUsers() {
        return null;
    }

    public UserDTO getUserById(Long id) {
        return null;
    }

    public void deleteUserById(Long id) {

    }
}
