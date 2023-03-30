package com.haftom.developinganapi.repository;

import com.haftom.developinganapi.model.Course;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends CrudRepository<Course, Long> {

    Iterable<Course> findAllByCategory(String category);
}
