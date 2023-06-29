package com.api.udemuz.repositories;

import com.api.udemuz.entities.User;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Created by Abdulaziz Pulatjonov
 * Date: 06/29/2023 03:23
 */


@Repository
public interface UserRepository extends BaseRepository<User, Long> {
    Optional<User> findByUserNameOrEmail(String username);
}
