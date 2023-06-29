package com.api.udemuz.services;

import com.api.udemuz.constant.Constants;
import com.api.udemuz.dto.AuthenticateDTO;
import com.api.udemuz.entities.User;
import com.api.udemuz.repositories.UserRepository;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.api.udemuz.exceptions.*;

import java.util.regex.Pattern;

/**
 * Created by Abdulaziz Pulatjonov
 * Date: 06/29/2023 03:50
 */

@Service("userService")
@Transactional
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@AllArgsConstructor(access = AccessLevel.PUBLIC)
@Slf4j
public class UserServiceImp extends BaseService implements UserService, Constants{

    @Autowired
    private UserRepository userRepository;


    @Override
    public AuthenticateDTO authenticate(AuthenticateDTO user) {
        validateEmail(user.getEmail());
        String loginCredentials = user.getEmail() == null ? user.getUsername() : user.getEmail();
        User userEntity = userRepository.findByUserNameOrEmail(user.getUsername())
                .orElseThrow(() -> new NotFoundException(USER_NOT_FOUND, User.class, "email/username"));
        return null;
    }

    /**
     * Checks if the given email passes all validations.
     * @param email must not be {@literal null}.
     * @throws InvalidEmailException if the given email does not match the email regex.
     */
    private void validateEmail(String email){
        if (!Pattern.matches(EMAIL_RFC_5322_REGEX, email.toLowerCase())){
            throw new InvalidEmailException(EMAIL_INVALID_MESSAGE, User.class, "email");
        }
    }
}
