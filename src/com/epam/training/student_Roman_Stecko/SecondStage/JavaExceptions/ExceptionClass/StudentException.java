package com.epam.training.student_Roman_Stecko.SecondStage.JavaExceptions.ExceptionClass;

public class StudentException extends Exception{
    public StudentException() {
        super();
    }

    public StudentException(String message) {
        super(message);
    }

    public StudentException(String message, Throwable cause) {
        super(message, cause);
    }

    public StudentException(Throwable cause) {
        super(cause);
    }
}
