package edu.co.icesi.introspringboot.service;

import edu.co.icesi.introspringboot.entity.Enrollment;
import edu.co.icesi.introspringboot.entity.Student;

import java.util.List;
import java.util.Optional;

public interface StudentService {

    List<Student> findAll();

    Optional<Student> findById(Integer id);

    Student save(Student student);

    void deleteById(Integer id);

    Student findStudentByCode(String code);

    List<Student> getStudentsByCourseName(String courseName);

    void deleteStudentByCode(String code);

    Enrollment enrollStudentInCourse(String studentCode, String courseName);

    void unenrollStudentFromCourse(String studentCode, String courseName);

}
