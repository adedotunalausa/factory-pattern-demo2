package com.pode.factorypatterndemo2.controller;

import com.pode.factorypatterndemo2.dto.StandardResponse;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

public class BaseController {

    @Autowired
    private HttpServletResponse httpServletResponse;

    <T extends StandardResponse> T responseWithUpdatedHttpStatus(T responseDto) {
        switch(responseDto.getHttpStatus()) {
            case OK -> httpServletResponse.setStatus(HttpStatus.OK.value());
            case CREATED -> httpServletResponse.setStatus(HttpStatus.CREATED.value());
            case NOT_FOUND -> httpServletResponse.setStatus(HttpStatus.NOT_FOUND.value());
            case BAD_REQUEST -> httpServletResponse.setStatus(HttpStatus.BAD_REQUEST.value());
            case FORBIDDEN -> httpServletResponse.setStatus(HttpStatus.FORBIDDEN.value());
            case UNAUTHORIZED -> httpServletResponse.setStatus(HttpStatus.UNAUTHORIZED.value());
            default -> httpServletResponse.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
        }

        return responseDto;
    }

}
