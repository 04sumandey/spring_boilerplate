package com.suman.spring_boilerplate.spring_boilerplate.common.responseUtil.dto;


import lombok.Builder;
import lombok.Data;

import java.util.Map;

@Data
@Builder
public class ErrorResponse {
    String errorCode;
    String errorMessage;
    Map<String, String> details;
}
