package com.badminton.service;

import com.badminton.domain.UserDTO;

import java.util.List;

public interface UserService {

    void addUser(UserDTO userDTO);

    List<UserDTO> getAllUsers ();

    UserDTO getUserById (Long id);

    void deleteUserById(Long id);

}
