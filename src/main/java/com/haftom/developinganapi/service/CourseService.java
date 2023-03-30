package com.haftom.developinganapi.service;

import com.haftom.developinganapi.model.Course;

import java.util.Optional;

public interface CourseService {

    Course createCourse(Course course);
    Optional<Course> getCourseById(long courseId);
    Iterable<Course> getCoursesByCategory(String category);
    Iterable<Course> getCourses();
    void updateCourse(long courseId, Course course);
    void deleteCourseById(long courseId);
    void deleteCourses();
}
