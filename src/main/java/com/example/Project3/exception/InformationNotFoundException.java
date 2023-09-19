package com.example.Project3.exception;

public class InformationNotFoundException extends RuntimeException{
    public InformationNotFoundException(String message){
        super(message);
    }
}
