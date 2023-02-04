package com.example.oracle_container_gyak.mapper;

import com.example.oracle_container_gyak.dto.StudentDTO;
import com.example.oracle_container_gyak.entity.Student;
import java.util.Collection;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public abstract class StudentMapper {

  public abstract StudentDTO studentToStudentDTO(Student student);

  public abstract Student studentDTOToStudent(StudentDTO studentDTO);

  public abstract Collection<StudentDTO> studentToStudentDTO(Collection<Student> students);
}
