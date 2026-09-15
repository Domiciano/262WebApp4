package edu.co.icesi.introspringboot.controller;


import edu.co.icesi.introspringboot.entity.Course;
import edu.co.icesi.introspringboot.entity.Professor;
import edu.co.icesi.introspringboot.repo.CourseRepository;
import edu.co.icesi.introspringboot.repo.ProfessorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/course")
public class CourseController {


    @Autowired
    private CourseRepository courseRepository;

    @GetMapping("/lab3")
    public List<Course> lab3() {
        return  courseRepository.findByCreditsEquals(3);
    }

    @GetMapping("/lab6")
    public List<Course> lab6() {
        return  courseRepository.findByProfessor_Name("Juan Perez");
    }

}
