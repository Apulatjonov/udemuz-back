package com.api.udemuz.entities;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.SQLDelete;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Set;

/**
 * Created by Abdulaziz Pulatjonov
 * Date: 06/29/2023 02:51
 */

@Getter
@Setter
@AllArgsConstructor
@Entity
@Table(name = "teachers")
@FieldDefaults(level = AccessLevel.PRIVATE)
@SQLDelete(sql = "UPDATE teachers SET deleted = 'true' WHERE id=?")
public class Teacher implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "teacher_id", nullable = false)
    Long teacherId;

    @Column(name = "teacher_name")
    String teacherName;

    @Column(name = "dob")
    LocalDate dateOfBirth;

    @Column(name = "join_date")
    LocalDate joinDate;

    @Column(name = "last_login")
    LocalDate lastLogin;

    @OneToMany(mappedBy = "teacher", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    Set<Course> courses;

    /**
     * User entity is separate
     * for separate login process
     */
    @OneToOne
    User user;

    public Teacher(){
        super();
        this.joinDate = LocalDate.now();
    }

}


