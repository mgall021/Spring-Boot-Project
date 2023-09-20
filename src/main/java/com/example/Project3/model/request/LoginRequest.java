package com.example.Project3.model.request;

/**
 * Represents a login request containing user credentials.
 * This class is used to encapsulate the user's login credentials, including their email address and password,
 * for authentication purposes.
 */
public class LoginRequest {
    private String emailAddress;
    private String password;

    public String getEmailAddress(){
        return emailAddress;
    }

    public String getPassword(){
        return password;
    }
}
