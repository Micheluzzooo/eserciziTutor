package com.example.crudTest.controller;

import com.example.crudTest.entity.Student;
import com.example.crudTest.repository.StudentRepository;
import com.example.crudTest.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @Autowired
    private StudentRepository studentRepository;

    @PostMapping("/createStudent")
    public @ResponseBody Student createStudent(@RequestBody Student student) {
        return studentRepository.save(student);
    }

    @GetMapping("/getAll")
    public @ResponseBody List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @GetMapping("/getStudent/{id}")
    public @ResponseBody Student getStudentById(@PathVariable Long id) {
        return studentRepository.findById(id).orElse(null);
    }

    @PutMapping("/setStudent/{id}")
    public Student updateStudent(@PathVariable Long id, @RequestBody Student newStudent) {
        Student student = studentRepository.findById(id).orElse(null);
        if (student != null) {
            student.setName(newStudent.getName());
            student.setSurname(newStudent.getSurname());
            return studentRepository.save(student);
        }
        return null;
    }

    @PutMapping("/setWorking/{id}")
    public @ResponseBody Student updateIsWorking(@PathVariable Long id, @RequestParam boolean working) {
       return studentService.changeIsWorking(id, working);
    }

    @DeleteMapping("/deleteById/{id}")
    public void deleteStudent(@PathVariable Long id) {
        studentRepository.deleteById(id);
    }
}
