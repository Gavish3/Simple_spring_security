package com.basicBank.practice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class BalanceController {

    @GetMapping("/myBalance")
    public String getBalances(){
        return "you are seeing balance here";
    }
}
