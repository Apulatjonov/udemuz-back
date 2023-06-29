package com.api.udemuz.entities;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.SQLDelete;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * Created by Abdulaziz Pulatjonov
 * Date: 06/29/2023 03:15
 */

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "enroll_course")
@FieldDefaults(level = AccessLevel.PRIVATE)
@SQLDelete(sql = "UPDATE enroll_course SET deleted = 'true' WHERE id=?")
public class EnrollCourse implements Serializable {
    @Getter(AccessLevel.NONE)
    @Setter(AccessLevel.NONE)
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    Long id;

    @OneToOne
    Course course;

    @Column(name = "enroll_date")
    LocalDate enrollDate;

    @OneToOne
    Student student;

    @OneToOne
    Teacher teacher;

    @ManyToOne
    @JoinColumn(name = "course_detail_id", nullable = false)
    CourseDetail courseDetail;
}
