package com.api.udemuz.exceptions;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by Abdulaziz Pulatjonov
 * Date: 06/29/2023 04:06
 */

@Getter
@Setter
public class InvalidPasswordException extends RuntimeException{
    private final Class type;
    private final String field;
    private final int status;

    /**
     * Instantiates a new Invalid password exception.
     *
     * @param message the message
     * @param type    the type
     * @param field   the field
     */
    public InvalidPasswordException(String message, Class type, String field) {
        super(message);
        this.field = field;
        this.type = type;
        this.status = 415;
    }
}
