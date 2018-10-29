package com.badminton;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication

public class BadmintonCourtsApplication {

    public static void main(String [] args){
        ConfigurableApplicationContext run = SpringApplication.run(BadmintonCourtsApplication.class, args);
    }




}
