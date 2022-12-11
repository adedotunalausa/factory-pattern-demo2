package com.pode.factorypatterndemo2.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public class BaseResponse<T> extends StandardResponse {

    private boolean status;
    private String message;
    private T data;

    public BaseResponse(boolean status, HttpStatus statusMessage, String message, T data) {
        super(statusMessage);
        this.status = status;
        this.message = message;
        this.data = data;
    }

}
