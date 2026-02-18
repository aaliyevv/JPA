package com.ltc.jpa.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import javax.sound.midi.MetaMessage;

@Data
public class CourseRequestDTO {

    @Size(min = 3, max = 10)
    private  String courseName;

    @Size(min = 3, max = 10, message = "more than 3 character")
    private String courseCode;

    @NotNull(message = "must be write anything")
    private String studentName;

    @NotBlank(message = "must not be blank")
    private String studentSurname;
}