package com.dailycodewithbuffer.spring.data.jpa.tutorial.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(
        name="tbl_student",
        uniqueConstraints = @UniqueConstraint(
                name="emailid_unique",
                columnNames = "email_id"
        )
)
public class Student {

    @Id
    @SequenceGenerator(
            name="student_sequence",
            sequenceName = "student_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "student_sequence"
    )
    private Long studentId;
    private String firstName;
    private String lastName;

    @Column(
            name="email_id",
            nullable = false
    )
    private String emailId;

    @Embedded
    private Guardian guardian;

}
