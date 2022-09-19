package com.example.Assignment3.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CandidateController {
    @Value("${db-string}")
    String dbString;

    @GetMapping("/")
    @ResponseBody
    public String hello(){
        return dbString;

    }
}
