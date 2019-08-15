package com.vadim.server.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class OAuth2AuthenticationProcessingException extends RuntimeException{
    public OAuth2AuthenticationProcessingException(final String message){
        super(message);
    }
}
