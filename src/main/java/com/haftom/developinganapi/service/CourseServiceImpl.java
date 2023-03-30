package com.haftom.developinganapi.service;

import com.haftom.developinganapi.model.Course;
import com.haftom.developinganapi.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CourseServiceImpl implements CourseService{

    @Autowired
    private CourseRepository courseRepository;

    @Override
    public Course createCourse(Course course) {
        return courseRepository.save(course);
    }

    @Override
    public Optional<Course> getCourseById(long courseId) {
        return courseRepository.findById(courseId);
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
    public void updateCourse(long courseId, Course course) {
        courseRepository.findById(courseId).ifPresent(c -> {
            c.setName(course.getName());
            c.setCategory(course.getCategory());
            c.setDescription(course.getDescription());
            c.setRating(course.getRating());
            courseRepository.save(c);
        });
    }

    @Override
    public void deleteCourseById(long courseId) {
        courseRepository.deleteById(courseId);
    }

    @Override
    public void deleteCourses() {
        courseRepository.deleteAll();
    }
}
