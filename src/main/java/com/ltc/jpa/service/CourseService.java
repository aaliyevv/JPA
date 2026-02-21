package com.ltc.jpa.service;

import com.ltc.jpa.dto.CourseRequestDTO;
import com.ltc.jpa.dto.CourseResponseDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface CourseService {

    CourseResponseDTO create(CourseRequestDTO courseRequestDTO);
    CourseResponseDTO getById (Long id);
    Page<CourseResponseDTO> getAll (Pageable pageable);
    CourseResponseDTO update (Long id, CourseRequestDTO courseRequestDTO);
    void delete (Long id);

}