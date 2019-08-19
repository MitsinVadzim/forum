package com.vadim.server.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
public class UnprocessableEntityException extends RuntimeException {

    public UnprocessableEntityException(final String message) {
        super(message);
    }

    public UnprocessableEntityException(final String message, final Throwable cause) {
        super(message, cause);
    }

}
