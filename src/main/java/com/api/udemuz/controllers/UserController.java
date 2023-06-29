package com.api.udemuz.controllers;

import com.api.udemuz.constant.ApiConstants;
import com.api.udemuz.dto.AuthenticateDTO;
import com.api.udemuz.services.UserService;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Abdulaziz Pulatjonov
 * Date: 06/29/2023 03:33
 */

@RestController
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class UserController {

    private final UserService userService;

    /**
     * @param userService the user service
     */
    @Autowired
    public UserController(@Qualifier("userService")UserService userService){
        this.userService = userService;
    }

    /**
     * This API takes a user dto as input, checks if such user exists in the database,
     * and returns the response entity with HttpStatus OK in case of such user exists
     * and the user isVerified status is true.
     *
     * @param authenticateDTO
     * @return the response entity
     */
    @PostMapping(ApiConstants.authentication)
    public ResponseEntity login(@RequestBody @Validated AuthenticateDTO authenticateDTO){
        return ResponseEntity.ok(userService.authenticate(authenticateDTO));
    }

}
