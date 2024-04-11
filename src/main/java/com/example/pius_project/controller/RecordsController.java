package com.example.pius_project.controller;

import com.example.pius_project.dto.CreateRecordRequestBody;
import com.example.pius_project.dto.RestoreRecordRequestBody;
import com.example.pius_project.dto.TestDto;
import com.example.pius_project.service.RecordService;
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
    private final RecordService recordService;

    public RecordsController(RecordService recordService) {
        this.recordService = recordService;
    }

    @PostMapping
    public void createRecord(@RequestBody CreateRecordRequestBody body, @RequestHeader(name = "user-id") long userId){
        recordService.createRecord(body, userId);
    }

    @GetMapping("{message}")
    public String test(@PathVariable String message, @RequestHeader(name = "user-id") long userId){
        System.out.println("test request" + message);
        return "OK";
    }

    @PostMapping("/restore")
    public void restoreRecord(@RequestBody RestoreRecordRequestBody body){
        recordService.restoreRecord(body);
    }




    
}
