package com.api.udemuz.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

/**
 * Created by Abdulaziz Pulatjonov
 * Date: 06/29/2023 04:16
 */

@Getter
@Setter
@Builder
@AllArgsConstructor
@Entity
@Table(name = "change_password_token")
public class ChangePasswordToken implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "token")
    private String token;

    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;

    private boolean isUsed;

    @OneToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    public ChangePasswordToken() {
    }

    /**
     * @param user
     * Change password token is generated
     * Based on the UUID random
     */
    public ChangePasswordToken(User user) {
        this.user = user;
        this.createdDate = new Date();
        this.token = UUID.randomUUID().toString();
        this.isUsed = false;
    }
}
