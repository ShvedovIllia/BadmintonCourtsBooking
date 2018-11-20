package com.badminton.service.impl;

import com.badminton.domain.UserDTO;
import com.badminton.entity.UserEntity;
import com.badminton.repository.UserRepository;
import com.badminton.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    public void addUser(UserDTO userDTO) {
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
