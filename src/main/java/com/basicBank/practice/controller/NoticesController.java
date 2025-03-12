package com.basicBank.practice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class NoticesController {

    @GetMapping("/notices")
    public String notices(){
        return "you are accessing notices here";
    }
}
