package com.suman.spring_boilerplate.spring_boilerplate.common.responseUtil;

import com.suman.spring_boilerplate.spring_boilerplate.common.exception.BadRequestException;
import com.suman.spring_boilerplate.spring_boilerplate.common.exception.ResourceNotFoundException;
import com.suman.spring_boilerplate.spring_boilerplate.common.responseUtil.dto.ErrorResponse;
import com.suman.spring_boilerplate.spring_boilerplate.common.responseUtil.dto.Response;
import com.suman.spring_boilerplate.spring_boilerplate.common.responseUtil.enums.ErrorCodeEnum;
import com.suman.spring_boilerplate.spring_boilerplate.common.responseUtil.enums.StatusCodeEnum;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;


@Data
@NoArgsConstructor
@Component
public class Util {
    public <T> Response<T> successBuilder(T data){
        return Response.<T>builder().status(StatusCodeEnum.ok.getCode()).data(data).build();
    }
    
    public <T> Response<T> FailureBuilder(Exception e){
        int status;
        ErrorResponse errorResponse;

        if (e instanceof NullPointerException) {
            status = StatusCodeEnum.internal_server_error.getCode();
            errorResponse = ErrorResponse.builder().errorCode(ErrorCodeEnum.InternalServerError.getCode())
                    .errorMessage("Null pointer encountered.").build();
        } else if (e instanceof IllegalArgumentException) {
            status = StatusCodeEnum.bad_request.getCode();
            errorResponse = ErrorResponse.builder().errorCode(ErrorCodeEnum.BadRequest.getCode())
                    .errorMessage("Invalid argument.").build();
        } else if (e instanceof ResourceNotFoundException) {
            status = StatusCodeEnum.not_found.getCode();
            errorResponse = ErrorResponse.builder().errorCode(ErrorCodeEnum.ResourceNotFound.getCode())
                    .errorMessage(e.getMessage()).build();
        } else if (e instanceof BadRequestException bre) {
            status = StatusCodeEnum.not_found.getCode();
            errorResponse = ErrorResponse.builder().errorCode(ErrorCodeEnum.BadRequest.getCode())
                    .errorMessage("Bad request").details(bre.getDetails()).build();
        } else {
            status = StatusCodeEnum.internal_server_error.getCode();
            errorResponse = ErrorResponse.builder().errorCode(ErrorCodeEnum.InternalServerError.getCode())
                    .errorMessage(e.getMessage()).build();
        }
        
        return Response.<T>builder().status(status).data(null).error(errorResponse).build();
    }
}
