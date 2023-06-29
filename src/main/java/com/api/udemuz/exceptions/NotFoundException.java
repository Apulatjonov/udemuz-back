package com.api.udemuz.exceptions;

import lombok.Getter;
import lombok.Setter;

/**
 * The type Not found exception.
 */
@Getter
@Setter
public class NotFoundException extends RuntimeException {
    private final Class type;
    private final String field;
    private final int status;

    /**
     * Instantiates a new Not found exception.
     *
     * @param message the message
     * @param type    the type
     * @param field   the field
     */
    public NotFoundException(String message, Class type, String field) {
        super(message);
        this.field = field;
        this.type = type;
        this.status = 404;
    }
}


