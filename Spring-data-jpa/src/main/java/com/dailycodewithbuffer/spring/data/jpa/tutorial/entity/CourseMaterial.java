package com.dailycodewithbuffer.spring.data.jpa.tutorial.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString(exclude ="course")  // we give fetch type as lazy so we want to fetch only courseMaterial not courses but toString method try to access courses also , so we exclude course from toString
// Course Material cannot exists itself , it has one to one relationship with course
public class CourseMaterial {

    @Id
    @SequenceGenerator(
            name="course_material_sequence",
            sequenceName = "course_material_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "course_material_sequence"
    )
    private Long courseMaterialId;
    private String url;

    @OneToOne(
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    @JoinColumn(
            name="course_id",
            referencedColumnName ="courseId"
    )
    private Course course;
}
