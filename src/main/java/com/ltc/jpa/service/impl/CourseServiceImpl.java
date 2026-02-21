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

