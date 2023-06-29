package com.api.udemuz.exceptions;

import lombok.Getter;
import lombok.Setter;

/**
 * The type Not verified account.
 */
@Getter
@Setter
public class NotVerifiedAccountException extends RuntimeException {
    private final Class type;
    private final String field;
    private final int status;

    /**
     * Instantiates a new Not verified account.
     *
     * @param message the message
     * @param type    the type
     * @param field   the field
     */
    public NotVerifiedAccountException(String message, Class type, String field) {
        super(message);
        this.field = field;
        this.type = type;
        this.status = 401;
    }
}
