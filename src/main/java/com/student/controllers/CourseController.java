package com.student.controllers;

import java.util.Iterator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.student.helper.ResponseWrapper;
import com.student.models.Course;
import com.student.models.Student;
import com.student.services.CourseService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/courses")
public class CourseController {
	
	@Autowired
	CourseService courseService;
	

	@GetMapping("")
	public ResponseEntity<?> getAllcourse()
	{
		Iterable<Course>cr=courseService.getAll();
		Iterator<Course>course_found = cr.iterator();
		if(!course_found.hasNext())
		{
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,"plz add course");
		}
		 ResponseWrapper srw= new ResponseWrapper();
		 srw.setMessage("all cpurse found");
		 srw.setData(course_found);
		 return new ResponseEntity<>(srw,HttpStatus.FOUND);

	}
	
	@PostMapping("")
	public ResponseEntity<?> createdcourse(@RequestBody @Valid Course course)
	{
    	Course	course_created=courseService.createcourse(course);
	    ResponseWrapper srw= new ResponseWrapper();
	    srw.setMessage("course created");
	    srw.setData(course_created);
	    return new ResponseEntity<>(srw,HttpStatus.CREATED);
		
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> courseById(@PathVariable int id)
	{
		Course course_id=courseService.getcourseId(id);
		 ResponseWrapper srw= new ResponseWrapper();
		 srw.setMessage("found by id");
		 srw.setData(course_id);
		 return new ResponseEntity<>(srw,HttpStatus.FOUND);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> updatedcourseById(@PathVariable int id , @RequestBody @Valid Course course)
	{
	  Course updated_course=courseService.updatecourse(id, course);
	  ResponseWrapper srw= new ResponseWrapper();
	  srw.setMessage("course updated");
	  srw.setData(updated_course);
      return new ResponseEntity<>(srw,HttpStatus.FOUND);
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deletedcourse(@PathVariable int id)
	{
		courseService.deletecourse(id);
		 ResponseWrapper srw= new ResponseWrapper();
		 srw.setMessage("course deleted");
		 srw.setData(null);
		 return new ResponseEntity<>(srw,HttpStatus.FOUND);
	}

}
