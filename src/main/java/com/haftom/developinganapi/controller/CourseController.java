package com.haftom.developinganapi.controller;

import com.haftom.developinganapi.model.Course;
import com.haftom.developinganapi.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/courses/")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @GetMapping
    public Iterable<Course> getAllCourses(){
        return courseService.getCourses();
    }

    @GetMapping("{id}")
    public Course getCourseById(@PathVariable ("id") long courseId){
        return courseService.getCourseById(courseId);
    }

    @GetMapping("category/{category}")
    public Iterable<Course> getCoursesByCategory(@PathVariable("category") String category){
        return courseService.getCoursesByCategory(category);
    }

    @PostMapping
    public Course createCourse(@RequestBody Course course){
        return courseService.createCourse(course);
    }

    @PutMapping("{id}")
    public Course updateCourse(@PathVariable("id") long courseId, @RequestBody Course course){
        return courseService.updateCourse(courseId, course);
    }

    @DeleteMapping("{id}")
    public void deleteCourseById(@PathVariable("id") long courseId){
        courseService.deleteCourseById(courseId);
    }

    @DeleteMapping
    public void deleteCourses(){
        courseService.deleteCourses();
    }
}
