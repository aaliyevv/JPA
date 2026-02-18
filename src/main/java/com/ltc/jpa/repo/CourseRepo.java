package com.ltc.jpa.repo;

import com.ltc.jpa.dto.StudentResponseDTO;
import com.ltc.jpa.model.CourseEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepo extends JpaRepository<CourseEntity, Long> {

}