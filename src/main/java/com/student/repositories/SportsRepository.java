package com.student.repositories;

import org.springframework.data.repository.CrudRepository;

import com.student.models.Sports;

public interface SportsRepository extends CrudRepository<Sports, Integer> {

}
