package com.example.Project3.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Custom exception indicating that the requested information already exists and conflicts with existing data.
 * This exception is thrown when an operation attempts to create or update data that already exists,
 * causing a conflict with the existing data.
 * @param message A custom error message describing the conflict or reason for the exception.
 */
@ResponseStatus(HttpStatus.CONFLICT)
public class InformationExistException extends RuntimeException{
    public InformationExistException(String message){
        super(message);
    }
}
