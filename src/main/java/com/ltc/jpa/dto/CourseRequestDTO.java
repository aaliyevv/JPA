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

