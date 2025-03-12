package com.basicBank.practice.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
public class SecurityConfig {
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http)throws Exception{
        http.csrf(csrfConfig->csrfConfig.disable());
//       http.sessionManagement(ssmc->ssmc.sessionFixation(sfc->sfc.none()));//CAUTION session fixation!!
//      http.cors(corsConfig->corsConfig.disable());
        //http.authorizeHttpRequests(request->request.anyRequest().permitAll());
        http.authorizeHttpRequests(request->request
                .requestMatchers("/api/v1/myAccount","/api/v1/myBalance","/api/v1/myCards","/api/v1/myLoans").authenticated()
                .requestMatchers("/api/v1/contactUs","/api/v1/notices","/error","/api/v1/register").permitAll());
        http.formLogin(withDefaults());
        http.httpBasic(withDefaults());
        return http.build();
    }
    @Bean
    public PasswordEncoder passwordEncoder(){
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }
}
