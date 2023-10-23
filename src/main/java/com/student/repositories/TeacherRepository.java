package com.student.repositories;

import org.springframework.data.repository.CrudRepository;

import com.student.models.Teacher;

public interface TeacherRepository extends CrudRepository<Teacher, Integer>{

}
