package com.smarthousing.auth.security;

import io.jsonwebtoken.Jwts;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.security.Keys;
import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.util.Date;

@Service
public class JwtService {

    private final JwtProperties jwtProperties;

    public JwtService(JwtProperties jwtProperties) {
        this.jwtProperties = jwtProperties;
    }

    private SecretKey getSigningKey() {

        return Keys.hmacShaKeyFor(
                jwtProperties.getSecret()
                        .getBytes(StandardCharsets.UTF_8)
        );
    }

    public String generateToken(
            Long userId,
            Long societyId,
            String role
    ) {

        return Jwts.builder()
                .subject(userId.toString())
                .claim("role", role)
                .claim("societyId", societyId)
                .issuedAt(new Date())
                .expiration(
                        new Date(
                                System.currentTimeMillis()
                                        + jwtProperties.getExpiration()
                        )
                )
                .signWith(getSigningKey())
                .compact();

    }
}
