package com.example.oracle_container_gyak.service;

import com.example.oracle_container_gyak.entity.Student;
import com.example.oracle_container_gyak.repository.StudentRepository;
import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class StudentService {

  private final StudentRepository studentRepository;

  public StudentService(StudentRepository studentRepository) {
    this.studentRepository = studentRepository;
  }

  public Collection<Student> findAll() {
    return studentRepository.findAll();
  }

  public Student findById(Integer id) {
    return studentRepository.findById(id).get();
  }

  public Student save(Student studentToSave) {
    return studentRepository.save(studentToSave);
  }
}
