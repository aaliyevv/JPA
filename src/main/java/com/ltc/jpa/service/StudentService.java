package com.ltc.jpa.service;


import com.ltc.jpa.dto.StudentRequestDTO;
import com.ltc.jpa.dto.StudentResponseDTO;

import java.util.List;

public interface StudentService {

    StudentResponseDTO create (StudentRequestDTO studentRequestDTO);

    StudentResponseDTO getById (Long id);

    List<StudentResponseDTO> getAll ();

    StudentResponseDTO update (Long id, StudentRequestDTO studentRequestDTO);

    List<StudentResponseDTO> getStudentsByCourseId(Long courseId);

    void delete (Long id);

}