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
import com.student.models.Student;
import com.student.models.Teacher;
import com.student.services.StudentService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/students")
public class StudentController {

	@Autowired
	StudentService studentService;
	
	@GetMapping("")
	public ResponseEntity<?> getAllstudent()
	{
		Iterable<Student>st=studentService.getAll();
		Iterator<Student>student_found = st.iterator();
		if(!student_found.hasNext())
		{
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,"plz add students");
		}
		 ResponseWrapper srw= new ResponseWrapper();
		 srw.setMessage("all student found");
		 srw.setData(student_found);
		 return new ResponseEntity<>(srw,HttpStatus.FOUND);

	}
	
	@PostMapping("")
	public ResponseEntity<?> createdStudent(@RequestBody @Valid Student student)
	{
    	Student	student_created=studentService.createStudent(student);
	    ResponseWrapper srw= new ResponseWrapper();
	    srw.setMessage("student created");
	    srw.setData(student_created);
	    return new ResponseEntity<>(srw,HttpStatus.CREATED);
		
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> studentById(@PathVariable int id)
	{
		 Student student_id=studentService.getstudentId(id);
		 ResponseWrapper srw= new ResponseWrapper();
		 srw.setMessage("found by id");
		 srw.setData(student_id);
		 return new ResponseEntity<>(srw,HttpStatus.FOUND);
	}
	
	
	
	@PutMapping("/{id}")
	public ResponseEntity<?> updatedStudentById(@PathVariable int id , @RequestBody @Valid Student student)
	{
	  Student updated_student=studentService.updateStudent(id, student);
	  ResponseWrapper srw= new ResponseWrapper();
	  srw.setMessage("student updated");
	  srw.setData(updated_student);
      return new ResponseEntity<>(srw,HttpStatus.FOUND);
	}
	
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deletedstudent(@PathVariable int id)
	{
		studentService.deletestudent(id);
		 ResponseWrapper srw= new ResponseWrapper();
		 srw.setMessage("student deleted");
		 srw.setData(null);
		 return new ResponseEntity<>(srw,HttpStatus.FOUND);
	}
	
	
	
	
	  @PutMapping("/{studentId}/sports/{sportId}")
	    public ResponseEntity<?> addSportToStudent(@PathVariable int studentId, @PathVariable int sportId) 
	    {
		    studentService.addSportToStudent(studentId, sportId);
             ResponseWrapper srw= new ResponseWrapper();
			 srw.setMessage("student add to sport");
             return new ResponseEntity<>(srw,HttpStatus.OK);
        }
	  
	  
	  
	  @PutMapping("/{studentId}/course/{courseId}")
	    public ResponseEntity<?> assignCourseToStudent(@PathVariable int studentId, @PathVariable int courseId)
	     {
	         Student add_course= studentService.assignCourseToStudent(studentId, courseId);
	          ResponseWrapper srw= new ResponseWrapper();
	         srw.setMessage("course add to student");
	         srw.setData(add_course);
	         return new ResponseEntity<>( srw,HttpStatus.OK);
	    }
	 
}
