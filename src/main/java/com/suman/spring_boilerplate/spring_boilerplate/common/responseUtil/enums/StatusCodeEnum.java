package com.suman.spring_boilerplate.spring_boilerplate.common.responseUtil.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum StatusCodeEnum {
    ok(200),
    bad_request(400),
    not_found(404),
    internal_server_error(500);
    final int code;
}
