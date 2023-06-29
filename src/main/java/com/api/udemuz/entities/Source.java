package com.api.udemuz.entities;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.SQLDelete;

import java.io.Serializable;

/**
 * Created by Abdulaziz Pulatjonov
 * Date: 06/29/2023 03:20
 */

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "sources")
@FieldDefaults(level = AccessLevel.PRIVATE)
@SQLDelete(sql = "UPDATE sources SET deleted = 'true' WHERE id=?")
public class Source implements Serializable {
    @Getter(AccessLevel.NONE)
    @Setter(AccessLevel.NONE)
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    Long id;

    @OneToOne
    Course course;

    @Column(name = "video_url")
    String videoUrl;

    @Column(name = "source_name")
    String sourceName;
}
