package com.wavekanit.Java_Spring_Authen_System.util;

import com.wavekanit.Java_Spring_Authen_System.model.UserModel;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;

@Component
public class JwtToken {
    private final Key key = Keys.secretKeyFor(SignatureAlgorithm.HS256);
    private final long duration = 3600000; // 1 hour duration

    public String generateToken(UserModel user) {
        return Jwts.builder()
                .setSubject(user.getUsername())
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + duration))
                .claim("id", user.getId())
                .signWith(key)
                .compact();
    }
}
