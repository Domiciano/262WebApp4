package edu.co.icesi.introspringboot.service;

import edu.co.icesi.introspringboot.entity.Course;
import edu.co.icesi.introspringboot.entity.Enrollment;
import edu.co.icesi.introspringboot.entity.Student;
import edu.co.icesi.introspringboot.repo.CourseRepository;
import edu.co.icesi.introspringboot.repo.EnrollmentRepository;
import edu.co.icesi.introspringboot.repo.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private CourseRepository courseRepository;
    @Autowired
    private EnrollmentRepository enrollmentRepository;

    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    public Optional<Student> findById(Integer id) {
        return studentRepository.findById(id);
    }

    @Transactional
    public Student save(Student student) {
        return studentRepository.save(student);
    }

    @Transactional
    public void deleteById(Integer id) {
        studentRepository.deleteById(id);
        enrollmentRepository.deleteByStudent_Id(id);
    }

    public Student findStudentByCode(String code) {
        // TODO: si el código es nulo o vacío, lanzar IllegalArgumentException.
        // TODO: buscar el estudiante por código; si no existe, lanzar RuntimeException.
        return null;
    }

    public List<Student> getStudentsByCourseName(String courseName) {
        // TODO: si el curso no existe, lanzar RuntimeException.
        // TODO: devolver los estudiantes inscritos en ese curso (puede ser una lista vacía).
        return null;
    }

    @Transactional
    public void deleteStudentByCode(String code) {
        // TODO: buscar el estudiante por código; si no existe, lanzar RuntimeException.
        // TODO: eliminarlo.
    }

    @Transactional
    public Enrollment enrollStudentInCourse(String studentCode, String courseName) {
        // TODO: buscar el estudiante por código; si no existe, lanzar RuntimeException.
        // TODO: buscar el curso por nombre; si no existe, lanzar RuntimeException.
        // TODO: si ya existe la inscripción, lanzar IllegalStateException.
        // TODO: crear y guardar la nueva inscripción.
        return null;
    }

    @Transactional
    public void unenrollStudentFromCourse(String studentCode, String courseName) {
        // TODO: buscar el estudiante por código; si no existe, lanzar RuntimeException.
        // TODO: buscar el curso por nombre; si no existe, lanzar RuntimeException.
        // TODO: buscar la inscripción; si no existe, lanzar IllegalStateException.
        // TODO: eliminarla.
    }
}
