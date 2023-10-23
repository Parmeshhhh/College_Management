package com.student.repositories;

import org.springframework.data.repository.CrudRepository;

import com.student.models.Student;

public interface StudentRepository extends CrudRepository<Student, Integer> {

}
