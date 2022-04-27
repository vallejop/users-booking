package com.example.usersbooking.security;

import com.example.usersbooking.model.Operator;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JWTGenerate {

    @Value("${app.secret}")
    private String secret;

    public String generateToken(Operator userDetails){
        return Jwts.builder()
                .setSubject(userDetails.getEmail())
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 10))
                .signWith(SignatureAlgorithm.HS256, secret)
                .compact();
    }

    public boolean validateToken(String token, Operator user) {
        return user.getEmail().equals(getEmail(token)) && !isTokenExpired(token);
    }

    public Claims getClaim(String token) {
        return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
    }

    public String getEmail(String token) {
        return getClaim(token).getSubject();
    }

    public boolean isTokenExpired(String token) {
        return getClaim(token)
                .getExpiration().before(new Date());
    }
}
