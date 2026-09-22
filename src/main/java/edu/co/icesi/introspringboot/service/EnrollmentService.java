package edu.co.icesi.introspringboot.service;

import edu.co.icesi.introspringboot.entity.Enrollment;

import java.util.List;
import java.util.Optional;

public interface EnrollmentService {

    List<Enrollment> findAll();

    Optional<Enrollment> findById(Integer id);

    Enrollment save(Enrollment enrollment);

    void deleteById(Integer id);

}
