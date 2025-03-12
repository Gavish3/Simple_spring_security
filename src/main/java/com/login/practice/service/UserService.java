package com.login.practice.service;

import com.login.practice.entity.Users;
import com.login.practice.repository.UsersRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private UsersRepository usersRepository;

    public UserService(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    public Users createUsers(Users users) {
        Users save = usersRepository.save(users);
        return save;
    }
}
