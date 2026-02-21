package com.ltc.jpa.service.impl;

import com.ltc.jpa.dto.CourseRequestDTO;
import com.ltc.jpa.dto.CourseResponseDTO;
import com.ltc.jpa.model.CourseEntity;
import com.ltc.jpa.repo.CourseRepo;
import com.ltc.jpa.service.CourseService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;


//Create Student Entity, set RequestDTO, save db
//Create Response Entity, set to saved db, return response

@Service
public class CourseServiceImpl implements CourseService {


    private final CourseRepo courseRepo;

    public CourseServiceImpl(CourseRepo courseRepo) {
        this.courseRepo = courseRepo;
    }

    @Override
    public CourseResponseDTO create(CourseRequestDTO courseRequestDTO) {

        CourseEntity courseEntity = new CourseEntity();

        courseEntity.setCourseName(courseRequestDTO.getCourseName());
        courseEntity.setCourseCode(courseRequestDTO.getCourseCode());
        courseEntity.setStudentName(courseRequestDTO.getStudentName());
        courseEntity.setStudentSurname(courseRequestDTO.getStudentSurname());

        CourseEntity courseDB = courseRepo.save(courseEntity);

        CourseResponseDTO courseResponseDTO = new CourseResponseDTO();

        courseResponseDTO.setId(courseDB.getId());
        courseResponseDTO.setCourseName(courseDB.getCourseName());
        courseResponseDTO.setCourseCode(courseDB.getCourseCode());
        courseResponseDTO.setStudentName(courseDB.getStudentName());
        courseResponseDTO.setStudentSurname(courseDB.getStudentSurname());

        return courseResponseDTO;
    }
}