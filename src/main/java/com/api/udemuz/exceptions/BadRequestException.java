package com.api.udemuz.exceptions;

import lombok.Getter;
import lombok.Setter;

/**
 * The type Bad request exception.
 */
@Getter
@Setter
public class BadRequestException extends RuntimeException {
    private final Class type;
    private final String field;
    private final int status;

    /**
     * Instantiates a new Bad request exception.
     *
     * @param message the message
     * @param type    the type
     * @param field   the field
     */
    public BadRequestException(String message, Class type, String field) {
        super(message);
        this.field = field;
        this.type = type;
        this.status = 400;
    }
}