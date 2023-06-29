package com.api.udemuz.entities;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.SQLDelete;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

/**
 * Created by Abdulaziz Pulatjonov
 * Date: 06/29/2023 04:14
 */

@Getter
@Setter
@Builder
@AllArgsConstructor
@Entity
@Table(name = "confirmation_token")
@FieldDefaults(level = AccessLevel.PRIVATE)
@SQLDelete(sql = "UPDATE confirmation_token SET deleted = 'true' WHERE id=?")
public class ConfirmationToken implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "token")
    private String token;

    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;

    @OneToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    public ConfirmationToken() {
    }

    /**
     * @param user
     * Confirmation token is generated
     * Based on the UUID random
     */
    public ConfirmationToken(User user) {
        this.user = user;
        this.createdDate = new Date();
        this.token = UUID.randomUUID().toString();
    }
}
