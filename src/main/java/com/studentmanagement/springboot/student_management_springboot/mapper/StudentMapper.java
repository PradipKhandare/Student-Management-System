package com.studentmanagement.springboot.student_management_springboot.mapper;

import com.studentmanagement.springboot.student_management_springboot.dto.StudentDTO;
import com.studentmanagement.springboot.student_management_springboot.entity.Student;

public class StudentMapper {

    public static StudentDTO mapStudentToStudentDTO(Student student) {
        StudentDTO studentDTO = new StudentDTO(
                student.getId(),
                student.getFirstName(),
                student.getLastName(),
                student.getEmail()
        );
        return studentDTO;
    }

    public static Student mapStudentDTOToStudent(StudentDTO studentDTO) {
        Student student = new Student(
                studentDTO.getId(), studentDTO.getFirstName(), studentDTO.getLastName(), studentDTO.getEmail()
        );
        return student;
    }
}
