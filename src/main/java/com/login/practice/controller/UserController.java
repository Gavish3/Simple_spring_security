package com.login.practice.controller;

import com.login.practice.entity.Users;
import com.login.practice.payload.LoginDto;
import com.login.practice.repository.UsersRepository;
import com.login.practice.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/api/demo/v1/users")
public class UserController {

    private UserService userService;
    private UsersRepository usersRepository;

    public UserController(UserService userService, UsersRepository usersRepository) {
        this.userService = userService;
        this.usersRepository = usersRepository;
    }
    @PostMapping("/signUp")
    public ResponseEntity<Users> addUsers(@RequestBody Users users){

        System.out.println(users.getMobile());
        Users saved = userService.createUsers(users);
        return new ResponseEntity<>(saved, HttpStatus.CREATED);
    }
    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginDto loginDto){
        Optional<Users> by = usersRepository.findByMobileOrUsername(loginDto.getMobileOrUsername());
        if (!by.isPresent()){
            return new ResponseEntity<>("username or mobile not exists",HttpStatus.NOT_FOUND);
        }
        else {
            Users users = by.get();
            if (loginDto.getPassword().equals(users.getPassword()) ){
                return new ResponseEntity<>(users.getUsername()+" has logged in",HttpStatus.OK);
            }
        }
        return new ResponseEntity<>("username/password invalid",HttpStatus.UNAUTHORIZED);
    }
}
