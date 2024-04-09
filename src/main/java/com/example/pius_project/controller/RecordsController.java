package com.example.pius_project.controller;

import com.example.pius_project.dto.TestDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/doctors/records")
public class RecordsController {

    @PostMapping
    public String test(@RequestBody TestDto testDto, @RequestHeader(name = "user-id") long userId){
        System.out.println("test request" + testDto.getMessage() + testDto.getId());
        return testDto.getMessage() + " dfhsryjdtyk";
    }

    @GetMapping("{message}")
    public String test(@PathVariable String message, @RequestHeader(name = "user-id") long userId){
        System.out.println("test request" + message);
        return "OK";
    }



    
}
