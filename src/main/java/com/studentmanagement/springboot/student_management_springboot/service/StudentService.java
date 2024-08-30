package com.studentmanagement.springboot.student_management_springboot.service;

import com.studentmanagement.springboot.student_management_springboot.dto.StudentDTO;

import java.util.List;

public interface StudentService {

    List<StudentDTO> getAllStudents();

    void createStudent(StudentDTO studentDTO);

    StudentDTO getStudentById(Long id);

    void updateStudent(StudentDTO studentDTO);

    void deleteStudent(Long studentId);
}
