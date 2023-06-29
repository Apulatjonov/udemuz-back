package com.api.udemuz.entities;

import com.api.udemuz.constant.UserRole;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.io.Serializable;

/**
 * Created by Abdulaziz Pulatjonov
 * Date: 06/29/2023 00:53
 */

@Entity
@Table(name = "users")
@Getter
@Setter
@Builder
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    Long id;

    @Column(name = "username", unique = true)
    String userName;

    @Column(name = "password")
    String password;

    /**
     * For now, app uses email
     * for user verification
     */
    @Column(name = "email", unique = true)
    String email;

    @Column(name = "verified")
    boolean verified;

    @Column(name = "role", length = 10)
    @Enumerated(EnumType.STRING)
    UserRole role;

    /**
     * When user first created,
     * it will be unverified
      */
    public User() {
        verified = false;
    }

    /**
     * There is a chance for this class
     * to have multiple objects in the
     * form of one user with multiple permissions,
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof User)) {
            return false;
        }
        return id != null && id.equals(((User) o).id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }

}
