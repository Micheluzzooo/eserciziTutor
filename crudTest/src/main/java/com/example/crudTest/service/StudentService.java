package com.example.crudTest.service;

import com.example.crudTest.entity.Student;
import com.example.crudTest.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public Student changeIsWorking(Long studentId, boolean isWorking) {
        Student student = studentRepository.findById(studentId).orElse(null);
        if (student != null) {
            student.setWorking(isWorking);
            studentRepository.save(student);
            return student;
        }
        return null;
    }
}
