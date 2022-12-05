package com.solvd.university.exception;

public class PassExamException extends  Exception {
    public PassExamException(String message) {
        super(message);
    }

    public PassExamException(String message, Throwable e){
        super(message, e);
    }
}
