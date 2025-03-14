package com.basicBank.practice.controller;

import com.basicBank.practice.util.SessionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class AccountController {

    @GetMapping("/myAccount")
    public String getAccountNumber(){
        String loggedInUser = SessionUtils.getLoggedInUsername();
        return "you are accessing account number here: "+ loggedInUser;
    }
}
