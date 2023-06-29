package com.api.udemuz.dto;

import com.api.udemuz.validator.CheckAtLeastOneNotNull;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import org.antlr.v4.runtime.misc.NotNull;

/**
 * Created by Abdulaziz Pulatjonov
 * Date: 06/29/2023 03:45
 */

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@CheckAtLeastOneNotNull(fieldNames = {"username", "email"})
public class AuthenticateDTO {

    Long id;
    String username;

    @NotNull
    String password;
    String email;
    boolean verified;


}
