package com.api.udemuz.entities;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.SQLDelete;

import java.io.Serializable;
import java.util.Set;

/**
 * Created by Abdulaziz Pulatjonov
 * Date: 06/29/2023 03:14
 */

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "course_details")
@FieldDefaults(level = AccessLevel.PRIVATE)
@SQLDelete(sql = "UPDATE course_details SET deleted = 'true' WHERE id=?")
public class CourseDetail implements Serializable {
    @Getter(AccessLevel.NONE)
    @Setter(AccessLevel.NONE)
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    Long id;

    @OneToOne
    Course course;

    @OneToMany(mappedBy = "courseDetail")
    Set<EnrollCourse> enrollCourses;


}
