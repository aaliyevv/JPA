package com.ltc.jpa.service.impl;

import com.ltc.jpa.dto.StudentRequestDTO;
import com.ltc.jpa.dto.StudentResponseDTO;
import com.ltc.jpa.model.CourseEntity;
import com.ltc.jpa.model.StudentEntity;
import com.ltc.jpa.model.enumaration.CourseStatus;
import com.ltc.jpa.repo.CourseRepo;
import com.ltc.jpa.repo.StudentRepo;
import com.ltc.jpa.service.StudentService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

//Create Student Entity, set RequestDTO, save db
//Create Response Entity, set to saved db, return response


@Service
public class StudentServiceImpl implements StudentService {

    public final StudentRepo studentRepo;
    private final CourseRepo courseRepo;


    public StudentServiceImpl(StudentRepo studentRepo, CourseRepo courseRepo) {
        this.studentRepo = studentRepo;
        this.courseRepo = courseRepo;
    }


    @Override
    public StudentResponseDTO create(StudentRequestDTO studentRequestDTO) {

        CourseEntity courseEntity = courseRepo.findById(studentRequestDTO.getCourseId())
                .orElseThrow(() -> new RuntimeException(
                        "Course Not Found" + studentRequestDTO.getCourseId()));

        StudentEntity studentEntity = new StudentEntity();

        studentEntity.setName(studentRequestDTO.getName());
        studentEntity.setSurname(studentRequestDTO.getSurname());
        studentEntity.setCourseStatus(studentRequestDTO.getCourseStatus());
        studentEntity.setCourse(courseEntity);

        StudentEntity studentDB = studentRepo.save(studentEntity);

        StudentResponseDTO studentResponseDTO = new StudentResponseDTO();

        studentResponseDTO.setId(studentDB.getId());
        studentResponseDTO.setName(studentDB.getName());
        studentResponseDTO.setSurname(studentDB.getSurname());
        studentResponseDTO.setCourseStatus(studentDB.getCourseStatus());
        studentResponseDTO.setCourseId(studentEntity.getCourse().getId());

        return studentResponseDTO;

    }

   