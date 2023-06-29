package com.api.udemuz.exceptions;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserAlreadyVerifiedException extends RuntimeException {
    private final Class type;
    private final String field;
    private final int status;

    /**
     * Instantiates a new Invalid email exception.
     *
     * @param message the message
     * @param type    the type
     * @param field   the field
     */
    public UserAlreadyVerifiedException(String message, Class type, String field) {
        super(message);
        this.field = field;
        this.type = type;
        this.status = 409;
    }
}
