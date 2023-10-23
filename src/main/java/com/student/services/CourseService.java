package com.student.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.student.models.Course;
import com.student.models.Student;
import com.student.repositories.CourseRepository;
import com.student.repositories.StudentRepository;

@Service
public class CourseService {

	@Autowired
	CourseRepository courseRepository;
	
	
	public Iterable<Course> getAll()
	{
		return courseRepository.findAll();
	}
	
	public Course createcourse(Course  course)
	{
		Course course_created=courseRepository.save(course);
		return  course_created;
	}
	
	 public Course getcourseId(int id )
     {
   	 return  courseRepository.findById(id).orElseThrow(()->
			{
				throw new ResponseStatusException(HttpStatus.NOT_FOUND,"course id does not exist");
			}
			);
     }
     public  Course  updatecourse(int id, Course course)
     {
    	 Course found_course= getcourseId(id);
    	 course.setId(found_course.getId());
    	 course.setCreaetdAt(found_course.getCreaetdAt());
    	 courseRepository.save(course);
    	 return found_course;
		
	}
     
     public void deletecourse(int id)
     {
         getcourseId(id);
    	 courseRepository.deleteById(id);
    	 
     }
}
