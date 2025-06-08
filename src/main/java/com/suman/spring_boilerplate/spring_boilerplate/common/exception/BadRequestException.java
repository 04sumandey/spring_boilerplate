package com.suman.spring_boilerplate.spring_boilerplate.common.exception;

import java.util.Map;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
public class BadRequestException extends RuntimeException{
    Map<String,String> details;
    public BadRequestException(){
        super();
    }

    public BadRequestException(String message){
        super(message);
    }

    public BadRequestException(String message,Throwable cause){
        super(message,cause);
    }

    public BadRequestException(Throwable cause){
        super(cause);
    }
}
