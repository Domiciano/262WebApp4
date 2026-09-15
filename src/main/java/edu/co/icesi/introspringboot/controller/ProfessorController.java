package edu.co.icesi.introspringboot.controller;


import edu.co.icesi.introspringboot.entity.Professor;
import edu.co.icesi.introspringboot.repo.ProfessorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/professor")
public class ProfessorController {


    @Autowired
    private ProfessorRepository professorRepository;

    @GetMapping("/lab2")
    public List<Professor> lab2() {
        return professorRepository.findByNameContainingIgnoreCase("Ana");
    }

}
