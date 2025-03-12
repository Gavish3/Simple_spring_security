package com.basicBank.practice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class CardsController {

    @GetMapping("/myCards")
    public String getCards(){
        return "you are accessing cards here";
    }
}
