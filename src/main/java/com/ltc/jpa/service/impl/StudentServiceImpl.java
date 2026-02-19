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

    @Override
    public StudentResponseDTO getById(Long id) {

        StudentEntity studentEntity = studentRepo.findById(id).orElseThrow(
                () -> new RuntimeException("Student NOt Found"));

        StudentResponseDTO studentResponseDTO = new StudentResponseDTO();

        studentResponseDTO.setId(studentEntity.getId());
        studentResponseDTO.setName(studentEntity.getName());
        studentResponseDTO.setSurname(studentEntity.getSurname());
        studentResponseDTO.setCourseStatus(studentEntity.getCourseStatus());
        studentResponseDTO.setCourseId(studentEntity.getCourse().getId());

        return studentResponseDTO;

    }

    @Override
    public List<StudentResponseDTO> getAll() {

        return studentRepo.findAll().stream()
                .map(studentEntity -> new StudentResponseDTO(
                        studentEntity.getId(),
                        studentEntity.getName(),
                        studentEntity.getSurname(),
                        studentEntity.getCourseStatus(),
                        studentEntity.getCourse() != null ? studentEntity.getCourse().getId() :
                                null))
                .toList();

    }

    @Override
    public StudentResponseDTO update(Long id, StudentRequestDTO studentRequestDTO) {

        StudentEntity studentEntity = studentRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Student Not Found"));

        studentEntity.setName(studentRequestDTO.getName());
        studentEntity.setSurname(studentRequestDTO.getSurname());
        studentEntity.setCourseStatus(studentRequestDTO.getCourseStatus());

        StudentEntity updatedStudentEntity = studentRepo.save(studentEntity);

        StudentResponseDTO studentResponseDTO = new StudentResponseDTO();
        studentResponseDTO.setId(updatedStudentEntity.getId());
        studentResponseDTO.setName(updatedStudentEntity.getName());
        studentResponseDTO.setSurname(updatedStudentEntity.getSurname());
        studentResponseDTO.setCourseStatus(updatedStudentEntity.getCourseStatus());

        return studentResponseDTO;

    }


    @Override
    public List<StudentResponseDTO> getStudentsByCourseId(Long courseId) {

        List<StudentEntity> students = studentRepo.findByCourseId(courseId);

        if (students.isEmpty()) {
            throw new RuntimeException("Students related to this course not found: " + courseId);
        }

        return students.stream()
                .map(s -> new StudentResponseDTO(
                        s.getId(),
                        s.getName(),
                        s.getSurname(),
                        s.getCourseStatus(),
                        s.getCourse() != null ? s.getCourse().getId() : null
                ))
                .toList();
    }

    @Override
    public void delete(Long id) {

        if (!studentRepo.existsById(id)) {
            throw new RuntimeException("Student Not Found" + id);
        }

        studentRepo.deleteById(id);

    }

}