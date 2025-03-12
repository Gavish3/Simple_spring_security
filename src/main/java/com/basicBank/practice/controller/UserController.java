package com.basicBank.practice.controller;

import com.basicBank.practice.entity.Customers;
import com.basicBank.practice.repository.CustomersRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class UserController {
    private CustomersRepository customersRepository;
    private PasswordEncoder passwordEncoder;

    public UserController(CustomersRepository customersRepository, PasswordEncoder passwordEncoder) {
        this.customersRepository = customersRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody Customers customers){
        try{
            String encode = passwordEncoder.encode(customers.getPassword());
           //String hashpw = BCrypt.hashpw(customers.getPassword(), BCrypt.gensalt(7));
            customers.setPassword(encode);
            Customers save = customersRepository.save(customers);

            return new ResponseEntity<>(customers, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>
                    ("something went wrong: "+e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR );
        }

    }
}
