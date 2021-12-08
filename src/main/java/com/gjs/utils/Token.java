package com.gjs.utils;

import com.gjs.entity.User;

import javax.xml.crypto.Data;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class Token {

    public static String encode(User user){
        return Base64.getEncoder().encodeToString((System.currentTimeMillis()+" "+user.getUserId() + " " + user.getAccount()).getBytes(StandardCharsets.UTF_8));
    }

    public static Integer decode(String token){
        byte[] decode = Base64.getDecoder().decode(token);
        String data = new String(decode);
        return Integer.valueOf(data.split(" ")[1]);

    }
}
