package com.freeLearn.wall.util;

import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class PasswordUtil {

    public String generateRandomPassword(int len){
        String PASSWORD_CHARS = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        int charLen = PASSWORD_CHARS.length();
        Random random = new Random();
        StringBuilder sb = new StringBuilder();
        int MAX_LEN = 64, MIN_LEN = 15;
        len = Math.min(len, MAX_LEN);
        len = Math.max(len, MIN_LEN);
        for(int i=0; i<len; i++){
            sb.append(PASSWORD_CHARS.charAt(random.nextInt(charLen)));
        }
        return sb.toString();
    }
}
