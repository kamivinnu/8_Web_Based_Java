package com.example.eureka.security;

import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import java.security.Key;

@Component
public class JwtUtil {

    private final String SECRET = "THIS_IS_MY_SECRET_KEY_CHANGE_IT_TO_256_BITS_LONG";

    private final Key key = Keys.hmacShaKeyFor(SECRET.getBytes());

    public Claims validateToken(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(token)
                .getBody();
    }
}
