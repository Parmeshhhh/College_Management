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
import com.student.models.Teacher;
import com.student.services.TeacherService;

import jakarta.validation.Valid;
@RestController
@RequestMapping("/teachers")
public class TeacherController {
	
	@Autowired
	TeacherService teacherService;
	
	@GetMapping("")
	public ResponseEntity<?> getAllteacher()
	{
		Iterable<Teacher>tr=teacherService.getAll();
		Iterator<Teacher>teacher_found = tr.iterator();
		if(!teacher_found.hasNext())
		{
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,"plz add teacher");
		}
		 ResponseWrapper srw= new ResponseWrapper();
		 srw.setMessage("all cpurse found");
		 srw.setData(teacher_found);
		 return new ResponseEntity<>(srw,HttpStatus.FOUND);

	}
	
	@PostMapping("")
	public ResponseEntity<?> createdteacher(@RequestBody @Valid Teacher teacher)
	{
    	Teacher	teacher_created=teacherService.createteacher(teacher);
	    ResponseWrapper srw= new ResponseWrapper();
	    srw.setMessage("teacher created");
	    srw.setData(teacher_created);
	    return new ResponseEntity<>(srw,HttpStatus.CREATED);
		
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> courseById(@PathVariable int id)
	{
		Teacher teacher_id=teacherService.getteacherId(id);
		 ResponseWrapper srw= new ResponseWrapper();
		 srw.setMessage("found by id");
		 srw.setData(teacher_id);
		 return new ResponseEntity<>(srw,HttpStatus.FOUND);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> updatedteacherById(@PathVariable int id , @RequestBody @Valid Teacher teacher)
	{
	  Teacher updated_teacher=teacherService.updatedteacher(id, teacher);
	  ResponseWrapper srw= new ResponseWrapper();
	  srw.setMessage("teacher updated");
	  srw.setData(updated_teacher);
      return new ResponseEntity<>(srw,HttpStatus.FOUND);
	}
	
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deletedteacher(@PathVariable int id)
	{
		teacherService.deleteteacher(id);
		 ResponseWrapper srw= new ResponseWrapper();
		 srw.setMessage("teavher deleted");
		 srw.setData(null);
		 return new ResponseEntity<>(srw,HttpStatus.FOUND);
	}

	@PutMapping("/{teacherId}/student/{studentId}")
    public ResponseEntity<?> assignTeacherToStudent(@PathVariable int studentId, @PathVariable int teacherId) 
     {
         Teacher add_student =  teacherService.assignTeacherToStudent(studentId, teacherId);
         ResponseWrapper srw= new ResponseWrapper();
		 srw.setMessage("student add to teacher");
		 srw.setData(add_student);
        return new ResponseEntity<>(srw,HttpStatus.OK);
     }
	

}
