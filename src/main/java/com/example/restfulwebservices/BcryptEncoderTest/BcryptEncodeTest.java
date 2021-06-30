package com.example.restfulwebservices.BcryptEncoderTest;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class BcryptEncodeTest {
    public static void main(String[] args) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

        for (int i = 0; i <= 10; i++) {
            String encodedString = encoder.encode("Passwasdjasihuh2313542@42334");
            System.out.println(encodedString);

        }
    }
}
