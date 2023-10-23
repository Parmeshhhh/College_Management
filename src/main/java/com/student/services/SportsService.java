package com.student.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.student.models.Sports;
import com.student.models.Student;
import com.student.repositories.SportsRepository;
import com.student.repositories.StudentRepository;

@Service
public class SportsService {

	@Autowired
	SportsRepository sportsRepository;
	
	@Autowired
	StudentRepository studentRepository;
	
	public Iterable<Sports> getAll()
	{
		return sportsRepository.findAll();
	}
	
	public Sports createsport(Sports  sports)
	{
		Sports student_sport=sportsRepository.save(sports);
		return  student_sport;
	}
	
	 public Sports getsportId(int id )
     {
   	 return  sportsRepository.findById(id).orElseThrow(()->
			{
				throw new ResponseStatusException(HttpStatus.NOT_FOUND,"student id does not exist");
			}
			);
     }
     public  Sports  updatesport(int id, Sports sports)
     {
    	 Sports found_sport= getsportId(id);
    	 sports.setId(found_sport.getId());
    	 sports.setCreaetdAt(found_sport.getCreaetdAt());
    	 sportsRepository.save(sports);
    	 return found_sport;
		
	}
     
     public void deletesport(int id)
     {
         getsportId(id);
    	 sportsRepository.deleteById(id);
    	 
     }
     
     
//     public void addSportToStudent(int sportId, int studentId)
//     {
//         
//    	Sports sports =sportsRepository.findById(sportId).orElseThrow(()->{throw new ResponseStatusException(HttpStatus.NOT_FOUND,"student id does not exist");});    
//    	Student student =studentRepository.findById(studentId).orElseThrow(()->{throw new ResponseStatusException(HttpStatus.NOT_FOUND,"student id does not exist");});
//    	 sports.getStudents().add(student);
//    	 sportsRepository.save(sports);
//     }
}
