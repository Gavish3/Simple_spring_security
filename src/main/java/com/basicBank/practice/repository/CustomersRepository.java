package com.basicBank.practice.repository;

import com.basicBank.practice.entity.Customers;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CustomersRepository extends JpaRepository<Customers, Long> {
    Optional<Customers> findByEmail(String username);
}