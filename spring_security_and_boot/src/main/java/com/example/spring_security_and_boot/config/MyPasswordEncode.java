package com.example.spring_security_and_boot.config;

import org.springframework.security.crypto.password.PasswordEncoder;

import org.springframework.security.crypto.scrypt.SCryptPasswordEncoder;


public class MyPasswordEncode implements PasswordEncoder {

    private SCryptPasswordEncoder encoder = new SCryptPasswordEncoder();
    @Override
    public String encode(CharSequence rawPassword) {


        return this.encoder.encode(rawPassword);
    }

    @Override
    public boolean matches(CharSequence rawPassword, String encodedPassword) {
        if (this.encoder.matches(rawPassword,encodedPassword)){
            return true;
        }
        return false;
    }
}
