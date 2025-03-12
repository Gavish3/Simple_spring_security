package com.login.practice.repository;

import com.login.practice.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface UsersRepository extends JpaRepository<Users, Long> {
    @Query("select u from Users u where u.mobile=:x or u.username =:x")
    Optional<Users> findByMobileOrUsername(@Param("x") String mobileOrUsername);
}