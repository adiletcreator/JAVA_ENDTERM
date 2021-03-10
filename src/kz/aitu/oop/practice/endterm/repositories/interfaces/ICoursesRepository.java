package kz.aitu.oop.practice.endterm.repositories.interfaces;

import kz.aitu.oop.practice.endterm.entities.Assignments;
import kz.aitu.oop.practice.endterm.entities.Courses;

import java.util.List;

public interface ICoursesRepository {
    boolean createCourses(Courses courses);
    Courses getCourses(int course_id);
    List<Courses> getAllCourses();
    Courses deleteCourseById(int course_id);
    String getCredits();
}
