package com.gani.merchantcustomer.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.gani.merchantcustomer.entity.User;
import jakarta.validation.ValidationException;
import org.springframework.beans.factory.annotation.Value;

import java.nio.charset.StandardCharsets;
import java.time.Instant;
import java.util.HashMap;
import java.util.Map;

public class JwtUtil {

    @Value("${merchant_customer.jwt.secret_key}")
    private String secretKey;

    @Value("${merchant_customer.jwt.issuer}")
    private String issuer;

    @Value("${merchant_customer.jwt.expirationInSecond}")
    private Long expirationInSecond;

    public String generateToken(User user) {
        try{
            Algorithm algorithm = Algorithm.HMAC256(secretKey.getBytes(StandardCharsets.UTF_8));

            return JWT.create()
                    .withIssuer(issuer)
                    .withSubject(user.getId().toString())
                    .withExpiresAt(Instant.now().plusSeconds(expirationInSecond))
                    .withIssuedAt(Instant.now())
                    .withClaim("role", user.getRole().name())
                    .sign(algorithm);
        } catch (JWTCreationException exception) {
            throw new ValidationException("Failed to create token");
        }
    }

    public Boolean verifyToken(String token) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(secretKey.getBytes(StandardCharsets.UTF_8));

            JWTVerifier jwtVerifier = JWT.require(algorithm).build();
            DecodedJWT decodedJWT = jwtVerifier.verify(token);

            return decodedJWT.getIssuer().equals(issuer);
        } catch (JWTVerificationException e) {
            return false;
        }
    }

    public Map<String, String> getUserInfoByToken(String token) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(secretKey.getBytes(StandardCharsets.UTF_8));

            JWTVerifier jwtVerifier = JWT.require(algorithm).build();
            DecodedJWT decodedJWT = jwtVerifier.verify(token);

            Map<String, String> info = new HashMap<>();
            info.put("userId", decodedJWT.getSubject());
            info.put("role", decodedJWT.getClaim("role").asString());
            return info;
        } catch (JWTVerificationException e) {
            throw new ValidationException("Failed fetching data from token");
        }
    }
}
