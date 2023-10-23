package com.student.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.student.models.Sports;
import com.student.models.Student;
import com.student.models.Teacher;
import com.student.repositories.StudentRepository;
import com.student.repositories.TeacherRepository;

@Service
public class TeacherService {

	@Autowired
	TeacherRepository teacherRepository;
	@Autowired
	StudentRepository studentRepository;
	

	
	public Iterable<Teacher> getAll()
	{
		return teacherRepository.findAll();
	}
	
	public Teacher createteacher(Teacher  teacher)
	{
		Teacher teacher_created=teacherRepository.save(teacher);
		return  teacher_created;
	}
	
	 public Teacher getteacherId(int id )
     {
   	       return  teacherRepository.findById(id).orElseThrow(()->
			{
				throw new ResponseStatusException(HttpStatus.NOT_FOUND,"teacher id does not exist");
			}
			);
     }
	 
     public  Teacher  updatedteacher(int id, Teacher teacher)
     {
    	 Teacher teacher_id= getteacherId(id);
    	 teacher.setId(teacher_id.getId());
    	 teacher.setCreatedAt(teacher_id.getCreatedAt());
    	 teacherRepository.save(teacher);
    	 return teacher_id;
		
	}
     
     public void deleteteacher(int id)
     {
         getteacherId(id);
    	 teacherRepository.deleteById(id);
    	 
     }
    
     public Teacher assignTeacherToStudent(int studentId, int teacherId) 
     {
         Student student = studentRepository.findById(studentId).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Student not found"));
         
         Teacher teacher = teacherRepository.findById(teacherId).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Teacher not found"));
         
         student.setTeacher(teacher);
         return  teacherRepository.save(teacher);
     
     }
     
}    
