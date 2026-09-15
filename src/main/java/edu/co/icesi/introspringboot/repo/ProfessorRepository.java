package edu.co.icesi.introspringboot.repo;

import edu.co.icesi.introspringboot.entity.Professor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProfessorRepository extends JpaRepository<Professor, Integer> {
    List<Professor> findByNameContainingIgnoreCase(String name);
}
