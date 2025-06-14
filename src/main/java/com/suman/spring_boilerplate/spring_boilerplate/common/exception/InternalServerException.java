package com.suman.spring_boilerplate.spring_boilerplate.common.exception;

public class InternalServerException extends RuntimeException {
    public InternalServerException(){
        super();
    }

    public InternalServerException(String message){
        super(message);
    }

    public InternalServerException(String message,Throwable cause){
        super(message, cause);
    }
    public InternalServerException(Throwable cause){
        super(cause);
    }
}
