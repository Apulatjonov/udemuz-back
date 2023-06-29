package com.api.udemuz.services;

import com.api.udemuz.dto.AuthenticateDTO;
import com.api.udemuz.exceptions.*;

/**
 * Created by Abdulaziz Pulatjonov
 * Date: 06/29/2023 03:59
 */


public interface UserService {

    /**
     * Returns given UserDto entity.
     * @param user must not be {@literal null}.
     * @return given UserDto entity.
     * @throws NotFoundException if given user was not found in the database.
     * @throws InvalidPasswordException if {@literal password} in the given UserDto does not pass password validation.
     * @throws NotVerifiedAccountException if {@literal isVerified} user's status in the given UserDto is false.
     */
    AuthenticateDTO authenticate(AuthenticateDTO user);

}
