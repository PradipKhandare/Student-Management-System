package com.studentmanagement.springboot.student_management_springboot.repository;

import com.studentmanagement.springboot.student_management_springboot.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {

}
