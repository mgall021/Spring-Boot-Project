package com.example.Project3.response;
/**
 * Represents a response containing a JWT token after successful login.
 * This class is used to encapsulate the JWT token received as a response after a successful login operation.
 * It provides a getter and setter method for accessing the JWT token.
 */
public class LoginResponse {
    private String jwt;

    public LoginResponse(String jwt) {
        this.jwt = jwt;
    }

    public String getJwt() {
        return jwt;
    }

    public void setJwt(String jwt) {
        this.jwt = jwt;
    }
}
