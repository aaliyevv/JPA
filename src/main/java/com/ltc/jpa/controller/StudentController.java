package com.ltc.jpa.controller;

import com.ltc.jpa.dto.CourseRequestDTO;
import com.ltc.jpa.dto.CourseResponseDTO;
import com.ltc.jpa.dto.StudentRequestDTO;
import com.ltc.jpa.dto.StudentResponseDTO;
import com.ltc.jpa.service.StudentService;
import com.ltc.jpa.service.impl.StudentServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    private final StudentServiceImpl studentService;

    public StudentController(StudentServiceImpl studentService) {
        this.studentService = studentService;

    }


    @PostMapping("/create")
    public ResponseEntity <String> create (@RequestBody StudentRequestDTO studentRequestDTO){

        StudentResponseDTO studentResponseDTO = studentService.create(studentRequestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body("User Id: " + studentResponseDTO
                + "\n User Name: " + studentResponseDTO.getName());

    }

    @PutMapping("/{id}")
    public ResponseEntity <String> update (@PathVariable Long id, @RequestBody StudentRequestDTO studentRequestDTO){

        StudentResponseDTO studentResponseDTO = studentService.update(id, studentRequestDTO);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body("User Id: " + studentResponseDTO.getId()
                + "\n User Name: " + studentResponseDTO.getName());

    }


    @GetMapping("/{id}")
    public ResponseEntity <StudentResponseDTO> findById (@PathVariable Long id){

        StudentResponseDTO studentResponseDTO = studentService.getById(id);
        return ResponseEntity.status(HttpStatus.OK).body(studentResponseDTO);

    }


    @GetMapping
    public ResponseEntity<List<StudentResponseDTO>>  getAll(){

        List<StudentResponseDTO> studentResponseDTO = studentService.getAll();
        return ResponseEntity.status(HttpStatus.OK).body(studentResponseDTO);
    }


    @DeleteMapping("{/id}")
    public ResponseEntity<StudentResponseDTO> delete (@PathVariable Long id){

        studentService.delete(id);
        return ResponseEntity.notFound().build();

    }


}