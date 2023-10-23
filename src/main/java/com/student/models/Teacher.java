package com.student.models;

import java.time.Instant;
import java.util.List;

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
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
@Entity
@EntityListeners(AuditingEntityListener.class)
public class Teacher {
	

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Size(min = 3,max=30,message = "name must be between 3 to 30 charachters")
    @NotNull(message = "name cant be null")
	@Column(nullable = false)
	private String teacherName;
	
	@Size(min = 3,max=30,message = "name must be between 3 to 30 charachters")
	 @NotNull(message = "name cant be null")
	@Column(nullable = false)
	private String department;
	
	@Size(min = 3,max=30,message = "name must be between 3 to 30 charachters")
	 @NotNull(message = "name cant be null")
	@Column(nullable = false)
	private String specialzation;
	
	 @CreatedDate
	  private Instant createdAt;
	  
	  @LastModifiedDate
	  private Instant updatedAt;
	
	 @OneToMany(mappedBy="teacher")
	  private List<Student> students;

	public Teacher() {
		super();
	}

	public Teacher(int id,
			@Size(min = 3, max = 30, message = "name must be between 3 to 30 charachters") @NotNull(message = "name cant be null") String teacherName,
			@Size(min = 3, max = 30, message = "name must be between 3 to 30 charachters") @NotNull(message = "name cant be null") String department,
			@Size(min = 3, max = 30, message = "name must be between 3 to 30 charachters") @NotNull(message = "name cant be null") String specialzation,
			Instant createdAt, Instant updatedAt, List<Student> students) {
		super();
		this.id = id;
		this.teacherName = teacherName;
		this.department = department;
		this.specialzation = specialzation;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.students = students;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTeacherName() {
		return teacherName;
	}

	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getSpecialzation() {
		return specialzation;
	}

	public void setSpecialzation(String specialzation) {
		this.specialzation = specialzation;
	}

	public Instant getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Instant createdAt) {
		this.createdAt = createdAt;
	}

	public Instant getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Instant updatedAt) {
		this.updatedAt = updatedAt;
	}

	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}

	



}