package com.ltc.jpa.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class CourseResponseDTO {

    private Long id;

    private String courseName;

    private String courseCode;

    private String studentName;

    private String studentSurname;

}