package com.example.usersbooking.controller.security;

import com.example.usersbooking.model.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JWTGenerate {
    private static final String KEY = "lU1S4M4R1N";
    public String generateToken(UserDetails userDetails){
        return Jwts.builder().setSubject(userDetails.getUsername()).setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 10))
                .signWith(SignatureAlgorithm.HS256, KEY).compact();

    }

    public String generateTokenv2(User userDetails){
        return Jwts.builder().setSubject(userDetails.getEmail()).setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 10))
                .signWith(SignatureAlgorithm.HS256, KEY).compact();
    }

    public boolean validateToken(String token, User user) {
        return user.getEmail().equals(getEmail(token)) && !isTokenExpired(token);
    }

    public Claims getClaim(String token) {
        return Jwts.parser().setSigningKey(KEY).parseClaimsJws(token).getBody();
    }

    public String getEmail(String token) {
        return getClaim(token).getSubject();
    }

    public boolean isTokenExpired(String token) {
        return getClaim(token).getExpiration().before(new Date());
    }
}
