package kz.aitu.oop.practice.endterm.controllers;

import kz.aitu.oop.practice.endterm.entities.Courses;
import kz.aitu.oop.practice.endterm.repositories.interfaces.ICoursesRepository;

import java.util.List;

public class CoursesController {
    private final ICoursesRepository repo;

    public CoursesController(ICoursesRepository repo) { this.repo = repo; }

    public String createCourses(int course_id, String course_name, String course_instructor, int course_credits,
                                int profile_id) {

        Courses courses = new Courses(course_id, course_name, course_instructor, course_credits
        , profile_id);

        boolean created = repo.createCourses(courses);

        return (created ? "Course was created" : "Course creation was failed!");
    }

    public String getCourses(int course_id) {
        Courses courses = repo.getCourses(course_id);

        return (courses == null ? "Course was not found!" : courses.toString());
    }

    public String getAllCourses() { //method to get all courses from table
        List<Courses> courses = repo.getAllCourses();

        return courses.toString();
    }

    public String deleteCourse(int course_id) {
        Courses course = repo.deleteCourseById(course_id);
        return (course == null ? "Course was deleted" : "Course was not found!");
    }

    public String getCredits() {
        String courses = repo.getCredits();
        return courses.toString();
    }

}
