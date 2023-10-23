package com.student.repositories;

import org.springframework.data.repository.CrudRepository;

import com.student.models.Course;

public interface CourseRepository  extends CrudRepository<Course, Integer>{

}
