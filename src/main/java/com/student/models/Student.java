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
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
@Entity
@EntityListeners(AuditingEntityListener.class)
public class Student {
	

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	 @Size(min = 3,max=30,message = "name must be between 3 to 30 charachters")
	 @NotNull(message = "name cant be null")
	 @Column(nullable = false,unique = false)
	 private String name;
	
	 @Size(min = 3,max=30,message = "city must be between 3 to 30 charachters")
	 @NotNull(message = "city cant be null")
	 @Column(nullable = false,unique = false)
	 private String city;
	
	 @Size(min = 10,max=10,message = "phone number must be in 10 digit")
	 @NotNull(message = "phone cant be null")
	 @Column(nullable = false,unique = false)
	 private String phone;
	
	
	  @CreatedDate
	  private Instant creaetdAt;
	  
	  @LastModifiedDate
	  private Instant upadtedAt;

	  
	  @OneToOne
	  @JoinColumn(name="course_id")
	  private Course course;
	  
	  @ManyToOne
		 @JoinColumn(name = "teacher_id")
		@JsonIgnore
		private Teacher teacher;

	  @ManyToMany
	  @JoinTable(
			  name="student_sports",
			  joinColumns = @JoinColumn(name="student_id"),
			  inverseJoinColumns = @JoinColumn(name="sp_id")
			  )
	  @JsonIgnore
	  private List<Sports> sports;

	public Student() {
		super();
	}

	public Student(int id,
			@Size(min = 3, max = 30, message = "name must be between 3 to 30 charachters") @NotNull(message = "name cant be null") String name,
			@Size(min = 3, max = 30, message = "city must be between 3 to 30 charachters") @NotNull(message = "city cant be null") String city,
			@Size(min = 10, max = 10, message = "phone number must be in 10 digit") @NotNull(message = "phone cant be null") String phone,
			Instant creaetdAt, Instant upadtedAt, Course course, Teacher teacher, List<Sports> sports) {
		super();
		this.id = id;
		this.name = name;
		this.city = city;
		this.phone = phone;
		this.creaetdAt = creaetdAt;
		this.upadtedAt = upadtedAt;
		this.course = course;
		this.teacher = teacher;
		this.sports = sports;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
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

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

	public List<Sports> getSports() {
		return sports;
	}

	public void setSports(List<Sports> sports) {
		this.sports = sports;
	}


	  
	  
}