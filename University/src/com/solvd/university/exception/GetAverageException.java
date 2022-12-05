package com.solvd.university.exception;

public class GetAverageException extends  Exception {
    public GetAverageException(String message) {
        super(message);
    }

    public GetAverageException(String message, Throwable e){
        super(message, e);
    }
}
