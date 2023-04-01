package com.haftom.developinganapi.service;

import com.haftom.developinganapi.exception.CourseNotFoundException;
import com.haftom.developinganapi.model.Course;
import com.haftom.developinganapi.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseServiceImpl implements CourseService{

    @Autowired
    private CourseRepository courseRepository;

    @Override
    public Course createCourse(Course course) {
        return courseRepository.save(course);
    }

    @Override
    public Course getCourseById(long courseId) {

        return courseRepository.findById(courseId)
                .orElseThrow(() -> new CourseNotFoundException
                        (String.format("No course with id %s is available", courseId)));
    }

    @Override
    public Iterable<Course> getCoursesByCategory(String category) {
        return courseRepository.findAllByCategory(category);
    }

    @Override
    public Iterable<Course> getCourses() {
        return courseRepository.findAll();
    }

    @Override
    public Course updateCourse(long courseId, Course course) {
        Course existingCourse = courseRepository.findById(courseId)
                .orElseThrow(() -> new CourseNotFoundException
                        (String.format("No course with id %s is available", courseId)));
        existingCourse.setName(course.getName());
        existingCourse.setCategory(course.getCategory());
        existingCourse.setDescription(course.getDescription());
        existingCourse.setRating(course.getRating());
        return courseRepository.save(existingCourse);
    }

    @Override
    public void deleteCourseById(long courseId) {
        courseRepository.findById(courseId).orElseThrow(() -> new CourseNotFoundException
                (String.format("No course with id %s is available", courseId)));
        courseRepository.deleteById(courseId);
    }

    @Override
    public void deleteCourses() {
        courseRepository.deleteAll();
    }
}
