package com.basicBank.practice.configuration;

import com.basicBank.practice.entity.Customers;
import com.basicBank.practice.repository.CustomersRepository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BankUserDetailService implements UserDetailsService {

    private CustomersRepository customersRepository;

    public BankUserDetailService(CustomersRepository customersRepository) {
        this.customersRepository = customersRepository;
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Customers customer = customersRepository.findByEmail(username)
                .orElseThrow(() -> new UsernameNotFoundException("username not found: " + username));
        List<GrantedAuthority> authorities = List.of(new SimpleGrantedAuthority(customer.getRole()));
        return new User(customer.getEmail(),customer.getPassword(), authorities);
    }
}
