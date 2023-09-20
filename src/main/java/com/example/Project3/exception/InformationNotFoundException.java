package com.example.Project3.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Custom exception indicating that the requested information was not found.
 * This exception is thrown when an operation attempts to access or retrieve information that does not exist,
 * causing a conflict due to the absence of the requested data.
 * @param message A custom error message describing the reason for the information not being found.
 */

@ResponseStatus(HttpStatus.CONFLICT)
public class InformationNotFoundException extends RuntimeException{
    public InformationNotFoundException(String message){
        super(message);
    }
}
