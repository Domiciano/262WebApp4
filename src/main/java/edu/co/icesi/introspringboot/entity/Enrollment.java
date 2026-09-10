package edu.co.icesi.introspringboot.entity;

import edu.co.icesi.introspringboot.entity.keys.StudentCourseId;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "student_course")
@Getter
@Setter
@NoArgsConstructor
public class Enrollment {

    @EmbeddedId
    private StudentCourseId id;

    @ManyToOne
    @MapsId("studentId")
    @JoinColumn(name = "student_id")
    private Student student;

    @ManyToOne
    @MapsId("courseId")
    @JoinColumn(name = "course_id")
    private Course course;
}
