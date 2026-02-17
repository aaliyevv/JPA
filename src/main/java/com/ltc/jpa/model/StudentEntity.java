package com.ltc.jpa.model;

import com.ltc.jpa.model.enumaration.CourseStatus;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table (name = "Students")
public class StudentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)  // .ORDINAL returns 0, 1
    private CourseStatus courseStatus;

    @Column(length = 10, nullable = false, name = "project_name")
    private String name;

    @Column(length = 20, nullable = false)
    private String surname;

/*
    @Column(length = 30, nullable = false, unique = true)
    @Email(message = "Email has been used.")
    private String email;
*/

    @ManyToOne
    @JoinColumn(name = "course_id")
    private CourseEntity course;

}