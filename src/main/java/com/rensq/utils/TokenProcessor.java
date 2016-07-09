package com.rensq.utils;

import sun.misc.BASE64Encoder;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Random;

/**
 * Created by toothbond on 16/7/9.
 */
public class TokenProcessor {

    private TokenProcessor(){}

    private static final TokenProcessor instance = new TokenProcessor();

    public static TokenProcessor getInstance(){
        return instance;
    }

    public String makeToken(){
        String token = (System.currentTimeMillis() + new Random().nextInt(99999999)) + "";

        try {
            MessageDigest md = MessageDigest.getInstance("md5");
            byte[] digest = md.digest(token.getBytes());
            BASE64Encoder encoder = new BASE64Encoder();
            return encoder.encode(digest);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        return null;
    }
}
