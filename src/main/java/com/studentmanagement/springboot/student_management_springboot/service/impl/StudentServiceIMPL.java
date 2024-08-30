package com.studentmanagement.springboot.student_management_springboot.service.impl;


import com.studentmanagement.springboot.student_management_springboot.dto.StudentDTO;
import com.studentmanagement.springboot.student_management_springboot.entity.Student;
import com.studentmanagement.springboot.student_management_springboot.mapper.StudentMapper;
import com.studentmanagement.springboot.student_management_springboot.repository.StudentRepository;
import com.studentmanagement.springboot.student_management_springboot.service.StudentService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class StudentServiceIMPL implements StudentService {


   private StudentRepository studentRepository;

    public StudentServiceIMPL(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public List<StudentDTO> getAllStudents() {
        List<Student> students =studentRepository.findAll();
        List<StudentDTO> studentDTOS = students.stream().map((student)-> StudentMapper.mapStudentToStudentDTO(student))
                .collect(Collectors.toList());
        return studentDTOS;
    }

    @Override
    public void createStudent(StudentDTO studentDTO) {
        Student student = StudentMapper.mapStudentDTOToStudent(studentDTO);
        studentRepository.save(student);
    }

    @Override
    public StudentDTO getStudentById(Long id) {
       Student student = studentRepository.findById(id).get();
       StudentDTO studentDTO = StudentMapper.mapStudentToStudentDTO(student);
       return studentDTO;
    }

    @Override
    public void updateStudent(StudentDTO studentDTO) {
       Student student = studentRepository.save(StudentMapper.mapStudentDTOToStudent(studentDTO));

    }

    @Override
    public void deleteStudent(Long studentId) {
        studentRepository.deleteById(studentId);
    }
}
