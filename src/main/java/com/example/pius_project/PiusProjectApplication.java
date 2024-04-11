package com.example.pius_project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class PiusProjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(PiusProjectApplication.class, args);
    }

}
