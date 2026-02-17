package com.ltc.jpa.repo;

import com.ltc.jpa.dto.StudentResponseDTO;
import com.ltc.jpa.model.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepo extends JpaRepository<StudentEntity, Long> {

    List<StudentEntity> findByCourseId(Long courseId);

}