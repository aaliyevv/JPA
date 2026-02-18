package com.ltc.jpa.dto;

import com.ltc.jpa.model.enumaration.CourseStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class StudentRequestDTO {

    private String name;
    private String surname;
    private CourseStatus courseStatus;
    private Long courseId; //FK

}