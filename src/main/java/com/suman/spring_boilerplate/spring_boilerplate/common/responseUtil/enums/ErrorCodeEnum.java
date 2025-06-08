package com.suman.spring_boilerplate.spring_boilerplate.common.responseUtil.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorCodeEnum {
    BadRequest("BAD REQUEST"),
    ResourceNotFound("RESOURCE NOT FOUND"),
    InternalServerError("INTERNAL SERVER ERROR");
    final String code;
}

