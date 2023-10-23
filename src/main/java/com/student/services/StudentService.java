package com.student.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.student.models.Course;
import com.student.models.Sports;
import com.student.models.Student;
import com.student.models.Teacher;
import com.student.repositories.CourseRepository;
import com.student.repositories.SportsRepository;
import com.student.repositories.StudentRepository;
import com.student.repositories.TeacherRepository;

@Service
public class StudentService {

	@Autowired
	StudentRepository studentRepository;
	
	@Autowired
	SportsRepository  sportsRepository;
	
	@Autowired
	TeacherRepository teacherRepository;
	
	@Autowired
	CourseRepository courseRepository;
	
	public Iterable<Student> getAll()
	{
		return studentRepository.findAll();
	}
	
	public Student createStudent(Student  student)
	{
		Student student_created=studentRepository.save(student);
		return  student_created;
	}
	
	 public Student getstudentId(int id )
     {
   	 return  studentRepository.findById(id).orElseThrow(()->
			{
				throw new ResponseStatusException(HttpStatus.NOT_FOUND,"student id does not exist");
			}
			);
     }
     public  Student  updateStudent(int id, Student student)
     {
    	 Student found_student= this.getstudentId(id);
    	 student.setId(found_student.getId());
    	 student.setCreaetdAt(found_student.getCreaetdAt());
    	 studentRepository.save(student);
    	 return found_student;
		
	}
     
     public void deletestudent(int id)
     {
         getstudentId(id);
    	 studentRepository.deleteById(id);
    	 
     }

     
     public void addSportToStudent(int studentId, int sportId)
     {
         Student student = studentRepository.findById(studentId).orElseThrow(() -> new IllegalArgumentException("student not found"));
         Sports sports = sportsRepository.findById(sportId).orElseThrow(() -> new IllegalArgumentException("sport not found"));
         student.getSports().add(sports);
          studentRepository.save(student);
     }
     

     public Student assignCourseToStudent(int studentId, int courseId)
     {
         Student student = getstudentId(studentId);
         Course course = courseRepository.findById(courseId).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Course id does not exist"));
         student.setCourse(course);
          return studentRepository.save(student);
     }
}
