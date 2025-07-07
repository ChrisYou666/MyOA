package com.company.oa.utils;

import io.jsonwebtoken.*;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.security.Key;
import java.util.Date;
import java.util.Map;

@Component
public class JwtUtil {
    private static Key KEY;
    private static long EXPIRATION;

    @Autowired
    public JwtUtil(
            @Value("${jwt.secret}") String base64Secret,
            @Value("${jwt.expiration-ms}") long expirationMs
    ) {
        byte[] keyBytes = Decoders.BASE64.decode(base64Secret);
        KEY = Keys.hmacShaKeyFor(keyBytes);
        EXPIRATION = expirationMs;
    }

    public static String generateToken(String username, Map<String,Object> claims) {
        long now = System.currentTimeMillis();
        return Jwts.builder()
                .setSubject(username)
                .addClaims(claims)
                .setIssuedAt(new Date(now))
                .setExpiration(new Date(now + EXPIRATION))
                .signWith(KEY)
                .compact();
    }

    public static Jws<Claims> parseToken(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(KEY)
                .build()
                .parseClaimsJws(token);
    }
}