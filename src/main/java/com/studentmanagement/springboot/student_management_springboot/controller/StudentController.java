package com.studentmanagement.springboot.student_management_springboot.controller;


import com.studentmanagement.springboot.student_management_springboot.dto.StudentDTO;
import com.studentmanagement.springboot.student_management_springboot.service.StudentService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class StudentController {

   private StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/students")
    public String listStudents(Model model){
        List<StudentDTO> students = studentService.getAllStudents();
        model.addAttribute("students", students);
        return "students";
    }

    @GetMapping("/students/new")
    public String newStudent(Model model){
        StudentDTO studentDTO = new StudentDTO();
        model.addAttribute("studentDTO", studentDTO);
        return "newStudent";
    }

    @PostMapping("/students")
    public String saveStudent(@Valid @ModelAttribute("studentDTO") StudentDTO studentDTO, BindingResult bindingResult, Model model){
        if(bindingResult.hasErrors()){
            model.addAttribute("studentDTO", studentDTO);
            return "newStudent";
        }
        studentService.createStudent(studentDTO);
         return "redirect:/students";
    }

    @GetMapping("/students/{studentId}/edit")
    public String editStudent(@PathVariable("studentId") Long id, Model model){
            StudentDTO studentDTO = studentService.getStudentById(id);
            model.addAttribute("studentDTO", studentDTO);
            return "editStudent";
    }


    @PostMapping("/students/{studentId}")
    public String updateStudent(@PathVariable("studentId") Long studentId,@Valid @ModelAttribute("studentDTO") StudentDTO studentDTO, BindingResult bindingResult, Model model){
        if(bindingResult.hasErrors()){
            model.addAttribute("studentDTO", studentDTO);
            return "editStudent";
        }
        studentDTO.setId(studentId);
        studentService.updateStudent(studentDTO);
        return "redirect:/students";
    }


    @GetMapping("/students/{studentId}/delete")
    public String deleteStudent(@PathVariable("studentId") Long studentId){
        studentService.deleteStudent(studentId);
        return "redirect:/students";
    }

    @GetMapping("/students/{studentId}/view")
    public String viewStudent(@PathVariable("studentId") Long studentId, Model model){
        StudentDTO studentDTO = studentService.getStudentById(studentId);
        model.addAttribute("studentDTO", studentDTO);
        return "viewStudent";
    }

}
