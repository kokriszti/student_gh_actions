package com.example.oracle_container_gyak.controller;

import com.example.oracle_container_gyak.dto.StudentDTO;
import com.example.oracle_container_gyak.entity.Student;
import com.example.oracle_container_gyak.mapper.StudentMapper;
import com.example.oracle_container_gyak.service.StudentService;
import java.net.URI;
import java.util.Collection;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/students")
public class StudentController {

  private final StudentService studentService;
  private final StudentMapper studentMapper;

  public StudentController(StudentService studentService, StudentMapper studentMapper) {
    this.studentService = studentService;
    this.studentMapper = studentMapper;
  }

  @GetMapping
  public ResponseEntity<Collection<StudentDTO>> findAll() {
    System.out.println("Find all called");
    return ResponseEntity.ok(studentMapper.studentToStudentDTO(studentService.findAll()));
  }

  @GetMapping("{id}")
  public ResponseEntity<StudentDTO> findById(@PathVariable int id) {
    return ResponseEntity.ok(studentMapper.studentToStudentDTO(studentService.findById(id)));
  }

  @PostMapping
  public ResponseEntity createStudent(@RequestBody StudentDTO studentDTO) {
    Student studentToSave = studentMapper.studentDTOToStudent(studentDTO);
    Student createdStudent = studentService.save(studentToSave);
    URI location = URI.create("students/" + createdStudent.getId());
    return ResponseEntity.created(location).build();
  }
}
