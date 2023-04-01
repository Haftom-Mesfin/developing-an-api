package com.haftom.developinganapi.service;

import com.haftom.developinganapi.model.Course;

public interface CourseService {

    Course createCourse(Course course);
    Course getCourseById(long courseId);
    Iterable<Course> getCoursesByCategory(String category);
    Iterable<Course> getCourses();
    Course updateCourse(long courseId, Course course);
    void deleteCourseById(long courseId);
    void deleteCourses();
}
