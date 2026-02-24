package com.ltc.jpa.controller;

import com.ltc.jpa.dto.CourseRequestDTO;
import com.ltc.jpa.dto.CourseResponseDTO;
import com.ltc.jpa.model.CourseEntity;
import com.ltc.jpa.repo.CourseRepo;
import com.ltc.jpa.service.CourseService;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
public class CourseController {

    private final CourseRepo courseRepo;
    private CourseService courseService;

    public CourseController(CourseService courseService, CourseRepo courseRepo) {
        this.courseService = courseService;
        this.courseRepo = courseRepo;
    }

}