package com.badminton.service.impl;

import com.badminton.domain.UserDTO;
import com.badminton.entity.UserEntity;
import com.badminton.repository.UserRepository;
import com.badminton.service.UserService;
import com.badminton.service.utils.ObjectMapperUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ObjectMapperUtils modelMapper;

    @Autowired
    private BCryptPasswordEncoder cryptPasswordEncoder;

    public void addUser(UserDTO userDTO) {

        UserEntity userEntity = modelMapper.map(userDTO, UserEntity.class);
        userEntity.setPassword(cryptPasswordEncoder.encode(userDTO.getPassword()));
        userRepository.save(userEntity);
    }

    public List<UserDTO> getAllUsers() {
        return modelMapper.mapAll(userRepository.findAll(), UserDTO.class);
    }

    public UserDTO getUserById(Long id) {

        return modelMapper.map(userRepository.findById(id), UserDTO.class);
    }

    public void deleteUserById(Long id) {
        userRepository.deleteById(id);

    }
}
