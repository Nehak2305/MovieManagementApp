package com.bej.authenticationservice.authenticationservice.service;

import com.bej.authenticationservice.authenticationservice.domain.User;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
@Service
public class SecurityJwtToken {
    public Map<String ,String> generateToken(User user){
        Map<String,String >map=null;
        String jwtToken=null;
        jwtToken = Jwts.builder()
                .setSubject(user.getUserName())
                .setIssuedAt(new Date())
                .signWith(SignatureAlgorithm.HS256,"Neha").compact();
        map=new HashMap<>();
        map.put("token",jwtToken);
        map.put("message","you logged in successfully");
        return map;
    }
}
