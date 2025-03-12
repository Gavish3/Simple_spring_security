package com.login.practice.payload;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginDto {
    private String mobileOrUsername;
    private String password;
}
