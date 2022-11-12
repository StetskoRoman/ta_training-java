package com.epam.training.student_Roman_Stecko.SecondStage.JavaExceptions.ExceptionClass;

public class UniversityException extends Exception{
    public UniversityException() {
        super();
    }

    public UniversityException(String message) {
        super(message);
    }

    public UniversityException(String message, Throwable cause) {
        super(message, cause);
    }

    public UniversityException(Throwable cause) {
        super(cause);
    }
}
