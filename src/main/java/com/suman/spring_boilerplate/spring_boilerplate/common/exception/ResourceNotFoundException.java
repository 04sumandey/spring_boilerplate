package com.suman.spring_boilerplate.spring_boilerplate.common.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException(){
        super();
    }

    public ResourceNotFoundException(String message){
        super(message);
    }

    public ResourceNotFoundException(String message,Throwable cause){
        super(message,cause);
    }

    public ResourceNotFoundException(Throwable cause){
        super(cause);
    }
}
