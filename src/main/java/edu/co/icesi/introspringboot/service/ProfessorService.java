package edu.co.icesi.introspringboot.service;

import edu.co.icesi.introspringboot.entity.Professor;
import edu.co.icesi.introspringboot.repo.ProfessorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class ProfessorService {

    @Autowired
    private ProfessorRepository professorRepository;


    @Transactional
    public void renameProfessor(Integer id, String name) {
        Optional<Professor> opProfessor = professorRepository.findById(id);
        if(opProfessor.isPresent()){
            Professor professor = opProfessor.get();
            professor.setName(name);
        } else throw new RuntimeException("Professor with id " + id + " not found");

    }
}
