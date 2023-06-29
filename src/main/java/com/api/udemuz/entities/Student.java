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
 * Date: 06/29/2023 01:23
 */

@Getter
@Setter
@Entity
@Builder
@AllArgsConstructor
@Table(name = "students")
@FieldDefaults(level = AccessLevel.PRIVATE)
@SQLDelete(sql = "UPDATE students SET deleted = 'true' WHERE id=?")
public class Student implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "student_id", nullable = false)
    Long studentId;

    @Column(name = "full_name")
    String fullName;

    @Column(name = "dob")
    LocalDate dateOfBirth;

    @Column(name = "join_date")
    LocalDate joinDate;

    @Column(name = "lastLogin")
    LocalDate lastLogin;

    /**
     * User entity is separate
     * for separate login process
     */
    @OneToOne
    User user;

    @ManyToMany(mappedBy = "students", fetch = FetchType.LAZY)
    Set<Course> courses;

    /**
     * The date student first joined
     * means student object created
     */
    public Student(){
        super();
        this.joinDate = LocalDate.now();
    }
}
