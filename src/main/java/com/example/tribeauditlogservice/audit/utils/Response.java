package com.example.tribeauditlogservice.audit.utils;

import lombok.*;
import org.springframework.http.HttpStatus;

import java.util.List;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Response<T> {
    private int statusCode;
    private String message;
    private HttpStatus status;
    private T data;
    private List<String> errors;

    public void setHttpStatusCode(){
        statusCode = status.value();
    }
}
