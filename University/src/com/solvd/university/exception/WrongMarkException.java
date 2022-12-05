package com.solvd.university.exception;

public class WrongMarkException extends RuntimeException {
    public WrongMarkException(String message) {
        super(message);
    }

    public WrongMarkException(String message, Throwable e){
        super(message, e);
    }
}
