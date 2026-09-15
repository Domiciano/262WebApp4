package edu.co.icesi.introspringboot.controller;


import edu.co.icesi.introspringboot.entity.Student;
import edu.co.icesi.introspringboot.repo.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentRepository studentRepository;

    @GetMapping("/lab1")
    public Optional<Student> lab1() {
        return studentRepository.findByCode("2021102001");
    }


}