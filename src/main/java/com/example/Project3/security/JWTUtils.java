package com.example.Project3.security;

import io.jsonwebtoken.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Utility class for handling JWT (JSON Web Token) operations.
 * This class provides methods for generating, parsing, and validating JWT tokens.
 * It is used in the authentication and authorization process to secure endpoints.
 */
@Service
public class JWTUtils {
    Logger logger = Logger.getLogger(JWTUtils.class.getName());
    @Value("${jwt-secret}")
    private String jwtSecret;

    @Value("86400")
    private int jwtExpirationMs;

    /**
     * Generate a JWT token for the provided user details.
     * @param myCustomerDetails The user details for whom the token is generated.
     * @return The generated JWT token.
     */
    public String generateJwtToken(MyCustomerDetails myCustomerDetails) {
        return Jwts.builder()
                .setSubject((myCustomerDetails.getUsername())) // just the user email
                .setIssuedAt(new Date())
                .setExpiration(new Date((new Date()).getTime() + jwtExpirationMs))
                .signWith(SignatureAlgorithm.HS256, jwtSecret)
                .compact();
    }


    /**
     * Get the customer's name (subject) from a JWT token.
     * @param token The JWT token to parse.
     * @return The customer's name (subject) extracted from the token.
     */
    public String getCustomerNameFromJwtToken(String token) {
        return Jwts.parserBuilder().setSigningKey(jwtSecret).build().parseClaimsJws(token).getBody().getSubject();
    }

    /**
     * Validate the integrity and expiration of a JWT token.
     *
     * @param authToken The JWT token to validate.
     * @return True if the token is valid, false otherwise.
     */
    public boolean validateJwtToken(String authToken) {
        try {
            Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(authToken);
            return true;
        } catch (SecurityException e) {
            logger.log(Level.SEVERE, "Invalid JWT signature: {}", e.getMessage());
        } catch (MalformedJwtException e) {
            logger.log(Level.SEVERE, "Invalid JWT token: {}", e.getMessage());
        } catch (ExpiredJwtException e) {
            logger.log(Level.SEVERE, "JWT token is expired: {}", e.getMessage());
        } catch (UnsupportedJwtException e) {
            logger.log(Level.SEVERE, "JWT token is unsupported: {}", e.getMessage());
        } catch (IllegalArgumentException e) {
            logger.log(Level.SEVERE, "JWT claims string is empty: {}", e.getMessage());
        }
        return false;
    }
}


