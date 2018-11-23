package com.badminton.controller;

import com.badminton.domain.UserDTO;
import com.badminton.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/allUsers")
    public ResponseEntity <List<UserDTO>> getAllUsers (){
        userService.getAllUsers();
        return new ResponseEntity<List<UserDTO>>(userService.getAllUsers(), HttpStatus.OK);
    }

    @PostMapping("/addUsers")
    public ResponseEntity <Void> addUser(@RequestBody UserDTO userDTO){
        userService.addUser(userDTO);
        return new ResponseEntity<Void>(HttpStatus.CREATED);
    }

    @GetMapping("/getUserById/{id}")
    public ResponseEntity<UserDTO> getUserById(@PathVariable Long id){
        userService.getUserById(id);
        return new ResponseEntity<UserDTO>(HttpStatus.OK);
    }

    @PutMapping("/updateUser/{id}")
    public ResponseEntity<Void> updateUser(@RequestBody UserDTO userDTO, @PathVariable Long id){
        userDTO.setId(id);
        userService.addUser(userDTO);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    @DeleteMapping("/deleteUser/{id}")
    public ResponseEntity<Void> deleteUserById(@PathVariable Long id){
        userService.deleteUserById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }


}