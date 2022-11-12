package com.epam.training.student_Roman_Stecko.SecondStage.JavaExceptions.ExceptionClass;

public class GroupException extends Exception{
    public GroupException() {
        super();
    }

    public GroupException(String message) {
        super(message);
    }

    public GroupException(String message, Throwable cause) {
        super(message, cause);
    }

    public GroupException(Throwable cause) {
        super(cause);
    }
}
