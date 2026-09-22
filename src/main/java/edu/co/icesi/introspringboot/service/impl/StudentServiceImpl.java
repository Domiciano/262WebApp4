package edu.co.icesi.introspringboot.service.impl;

import edu.co.icesi.introspringboot.entity.Course;
import edu.co.icesi.introspringboot.entity.Enrollment;
import edu.co.icesi.introspringboot.entity.Student;
import edu.co.icesi.introspringboot.repo.CourseRepository;
import edu.co.icesi.introspringboot.repo.EnrollmentRepository;
import edu.co.icesi.introspringboot.repo.StudentRepository;
import edu.co.icesi.introspringboot.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private CourseRepository courseRepository;
    @Autowired
    private EnrollmentRepository enrollmentRepository;

    @Override
    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    @Override
    public Optional<Student> findById(Integer id) {
        return studentRepository.findById(id);
    }

    @Override
    @Transactional
    public Student save(Student student) {
        return studentRepository.save(student);
    }

    @Override
    @Transactional
    public void deleteById(Integer id) {
        studentRepository.deleteById(id);
        enrollmentRepository.deleteByStudent_Id(id);
    }

    @Override
    public Student findStudentByCode(String code) {
        // TODO: si el código es nulo o vacío, lanzar IllegalArgumentException.
        // TODO: buscar el estudiante por código; si no existe, lanzar RuntimeException.
        return null;
    }

    @Override
    public List<Student> getStudentsByCourseName(String courseName) {
        // TODO: si el curso no existe, lanzar RuntimeException.
        // TODO: devolver los estudiantes inscritos en ese curso (puede ser una lista vacía).
        return null;
    }

    @Override
    @Transactional
    public void deleteStudentByCode(String code) {
        // TODO: buscar el estudiante por código; si no existe, lanzar RuntimeException.
        // TODO: eliminarlo.
    }

    @Override
    @Transactional
    public Enrollment enrollStudentInCourse(String studentCode, String courseName) {
        // TODO: buscar el estudiante por código; si no existe, lanzar RuntimeException.
        // TODO: buscar el curso por nombre; si no existe, lanzar RuntimeException.
        // TODO: si ya existe la inscripción, lanzar IllegalStateException.
        // TODO: crear y guardar la nueva inscripción.
        return null;
    }

    @Override
    @Transactional
    public void unenrollStudentFromCourse(String studentCode, String courseName) {
        // TODO: buscar el estudiante por código; si no existe, lanzar RuntimeException.
        // TODO: buscar el curso por nombre; si no existe, lanzar RuntimeException.
        // TODO: buscar la inscripción; si no existe, lanzar IllegalStateException.
        // TODO: eliminarla.
    }
}
