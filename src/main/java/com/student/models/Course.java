package com.student.models;

import java.time.Instant;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnore;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@EntityListeners(AuditingEntityListener.class)
public class Course {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	 @Size(min = 3,max=30,message = "coursename must be between 3 to 30 charachters")
	 @NotNull(message = "coursename cant be null")
	 @Column(nullable = false,unique = false)
	 private String courseName;
	
	 
	 @Size(min = 3,max=30,message = "cours duration must be between 3 to 30 charachters")
	 @NotNull(message = "course duration cant be null")
	 @Column(nullable = false,unique = false)
	 private String courseDuration;
	
	 
	 //@Size(min = 10000,max=100000,message = "price must be between 1000 to 1000000 ")
	 @NotNull(message = "price cant be null")
	 @Column(nullable = false,unique = false)
	 private String  price;
	 
	 
	 @CreatedDate
	  private Instant creaetdAt;
	  
	  @LastModifiedDate
	  private Instant upadtedAt;

	  
	  @OneToOne(mappedBy = "course")
	  @JsonIgnore
	  private Student student;


	public Course() {
	}


	public Course(int id,
			@Size(min = 3, max = 30, message = "coursename must be between 3 to 30 charachters") @NotNull(message = "coursename cant be null") String courseName,
			@Size(min = 3, max = 30, message = "cours duration must be between 3 to 30 charachters") @NotNull(message = "course duration cant be null") String courseDuration,
			@NotNull(message = "price cant be null") String price, Instant creaetdAt, Instant upadtedAt,
			Student student) {
		super();
		this.id = id;
		this.courseName = courseName;
		this.courseDuration = courseDuration;
		this.price = price;
		this.creaetdAt = creaetdAt;
		this.upadtedAt = upadtedAt;
		this.student = student;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getCourseName() {
		return courseName;
	}


	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}


	public String getCourseDuration() {
		return courseDuration;
	}


	public void setCourseDuration(String courseDuration) {
		this.courseDuration = courseDuration;
	}


	public String getPrice() {
		return price;
	}


	public void setPrice(String price) {
		this.price = price;
	}


	public Instant getCreaetdAt() {
		return creaetdAt;
	}


	public void setCreaetdAt(Instant creaetdAt) {
		this.creaetdAt = creaetdAt;
	}


	public Instant getUpadtedAt() {
		return upadtedAt;
	}


	public void setUpadtedAt(Instant upadtedAt) {
		this.upadtedAt = upadtedAt;
	}


	public Student getStudent() {
		return student;
	}


	public void setStudent(Student student) {
		this.student = student;
	}

	  
}

