package edu.co.icesi.introspringboot.controller;


import edu.co.icesi.introspringboot.entity.Student;
import edu.co.icesi.introspringboot.repo.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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

    @GetMapping("/lab9")
    public List<Student> lab9() {
        return studentRepository.findDistinctByStudentCourses_Course_Professor_Name("Marlon Gomez");
    }

    @GetMapping("/all")
    public Page<Student> findAll(@RequestParam int page) {
        return studentRepository.findAll(
                PageRequest.of(page, 3)
        );
    }
    // http://localhost:8080/students/all?page=3
    // http://www.google.com/search?q=alfredo%20bristo


}