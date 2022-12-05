package com.solvd.university.exception;

public class UniversityException extends RuntimeException {
    public UniversityException(String message) {
        super(message);
    }

    public UniversityException(String message, Throwable e){
        super(message, e);
    }
}
