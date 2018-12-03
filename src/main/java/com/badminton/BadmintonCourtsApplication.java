package com.badminton;

import com.badminton.entity.UserEntity;
import com.badminton.enums.Roles;
import com.badminton.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication

public class BadmintonCourtsApplication {

    public static void main(String [] args){
        ConfigurableApplicationContext run = SpringApplication.run(BadmintonCourtsApplication.class, args);;
        createAdmin();
    }
    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Autowired
    private UserRepository userRepository;

    public static void createAdmin(){
        UserEntity user = new UserEntity();
        user.setUsername("ADMIN");
        user.setPassword("ADMIN");
        user.setEmail("ADMIN");
        user.setRole(Roles.ADMIN);
        user.setDateOfBirth("ADMIN");
        user.setFirstName("ADMIN");
        user.setLastName("ADMIN");
        if (userRepository.count()==0) {
            userRepository.save(user);
        }
    }




}
