package edu.co.icesi.introspringboot.service;

import edu.co.icesi.introspringboot.entity.Course;
import edu.co.icesi.introspringboot.entity.Professor;

public interface CourseService {

    void createCourseWithProfessor(Course course, Professor professor);

    void deleteCourse(Integer id);

    Course createCourse(Course course);
}
