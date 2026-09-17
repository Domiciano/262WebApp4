package edu.co.icesi.introspringboot.service;

import edu.co.icesi.introspringboot.entity.Course;
import edu.co.icesi.introspringboot.entity.Professor;
import edu.co.icesi.introspringboot.repo.CourseRepository;
import edu.co.icesi.introspringboot.repo.EnrollmentRepository;
import edu.co.icesi.introspringboot.repo.ProfessorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;
    @Autowired
    private ProfessorRepository professorRepository;
    @Autowired
    private EnrollmentRepository enrollmentRepository;

    @Transactional
    public void createCourseWithProfessor(
            Course course,
            Professor professor
    ) {
        professorRepository.save(professor);
        courseRepository.save(course);
    }

    @Transactional
    public void deleteCourse(Integer id) {
        courseRepository.deleteById(id);
        //Eliminar los enrollments asociados
        enrollmentRepository.deleteByCourse_Id(id);
    }

}
