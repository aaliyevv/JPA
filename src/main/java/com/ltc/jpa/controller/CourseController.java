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

    @PostMapping("/create")
    public ResponseEntity <String> createCourse(@RequestBody CourseRequestDTO courseRequestDTO) {

        CourseResponseDTO courseResponseDTO = courseService.create(courseRequestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body("Course Id: " + courseResponseDTO.getId() +
                "Course Name: " + courseResponseDTO.getCourseName());

    }


    @PutMapping("{/id}")
    public ResponseEntity <CourseResponseDTO> updateCourse(@PathVariable Long id, @RequestBody CourseRequestDTO
            courseRequestDTO) {

        CourseResponseDTO courseResponseDTO = courseService.update(id, courseRequestDTO);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(courseResponseDTO);

    }

    @GetMapping("{/id}")
    public ResponseEntity<CourseResponseDTO> getCourse(@PathVariable Long id) {

        CourseResponseDTO courseResponseDTO = courseService.getById(id);
        return ResponseEntity.status(HttpStatus.OK).body(courseResponseDTO);

    }

    @GetMapping
    public ResponseEntity<Page<CourseResponseDTO>> getAllCourse(@ParameterObject
                                                                @PageableDefault(page = 0, size = 10, sort = "id",
                                                                        direction = Sort.Direction.DESC)
                                                                Pageable pageable) {

        Page<CourseResponseDTO> courseResponseDTO = courseService.getAll(pageable);
        return ResponseEntity.status(HttpStatus.OK).body(courseResponseDTO);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity deleteCourse(@PathVariable Long id) {

        courseService.delete(id);
        return ResponseEntity.notFound().build();
    }

}