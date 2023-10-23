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
import com.student.models.Sports;
import com.student.services.SportsService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/sports")
public class SportsController {
	
	@Autowired
	SportsService  sportsService;
	
	
	@GetMapping("")
	public ResponseEntity<?> getAllsports()
	{
		Iterable<Sports>cr=sportsService.getAll();
		Iterator<Sports>sport_found = cr.iterator();
		if(!sport_found.hasNext())
		{
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,"plz add sports");
		}
		 ResponseWrapper srw= new ResponseWrapper();
		 srw.setMessage("all sport found");
		 srw.setData(sport_found);
		 return new ResponseEntity<>(srw,HttpStatus.FOUND);

	}
	
	@PostMapping("")
	public ResponseEntity<?> createdsport(@RequestBody @Valid Sports sports)
	{
    	Sports	sport_created=sportsService.createsport(sports);
	    ResponseWrapper srw= new ResponseWrapper();
	    srw.setMessage("sport created");
	    srw.setData(sport_created);
	    return new ResponseEntity<>(srw,HttpStatus.CREATED);
		
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> sportById(@PathVariable int id)
	{
		Sports sport_id=sportsService.getsportId(id);
		 ResponseWrapper srw= new ResponseWrapper();
		 srw.setMessage("found by id");
		 srw.setData(sport_id);
		 return new ResponseEntity<>(srw,HttpStatus.FOUND);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> updatedsportById(@PathVariable int id , @RequestBody @Valid Sports sports)
	{
	  Sports updated_sport=sportsService.updatesport(id, sports);
	  ResponseWrapper srw= new ResponseWrapper();
	  srw.setMessage("course updated");
	  srw.setData(updated_sport);
      return new ResponseEntity<>(srw,HttpStatus.FOUND);
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deletedsport(@PathVariable int id)
	{
		sportsService.deletesport(id);
		 ResponseWrapper srw= new ResponseWrapper();
		 srw.setMessage("sport deleted");
		 srw.setData(null);
		 return new ResponseEntity<>(srw,HttpStatus.FOUND);
	}
//
//	@PutMapping("/{sportId}/students/{studentId}")
//    public ResponseEntity<?> addSportToStudent(@PathVariable int sportId, @PathVariable int studentId) {
//    sportsService.addSportToStudent(sportId, studentId);
//    return new ResponseEntity<>(HttpStatus.OK);
}


