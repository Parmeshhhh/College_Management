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
import jakarta.persistence.ManyToMany;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@EntityListeners(AuditingEntityListener.class)
public class Sports {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Column(nullable = false)
	@Size(min = 3,max=30,message = "name must be between 3 to 30 charachters")
	 @NotNull(message = "name cant be null")
	private String sportName;
	
	@Column(nullable = false)
	@Size(min = 3,max=30,message = "name must be between 3 to 30 charachters")
	 @NotNull(message = "name cant be null")
	private String sportType;
	
	@Column(nullable = false)
	@Size(min = 1,max=5,message = "name must be between 3 to 30 charachters")
	 @NotNull(message = "name cant be null")
	private String playerSize;
	
	 
	 @CreatedDate
	  private Instant creaetdAt;
	  
	  @LastModifiedDate
	  private Instant upadtedAt;

	  @ManyToMany(mappedBy= "sports")
	  @JsonIgnore
	  private List<Student>students;

	public Sports() {
		super();
	}

	public Sports(int id,
			@Size(min = 3, max = 30, message = "name must be between 3 to 30 charachters") @NotNull(message = "name cant be null") String sportName,
			@Size(min = 3, max = 30, message = "name must be between 3 to 30 charachters") @NotNull(message = "name cant be null") String sportType,
			@Size(min = 3, max = 30, message = "name must be between 3 to 30 charachters") @NotNull(message = "name cant be null") String playerSize,
			Instant creaetdAt, Instant upadtedAt, List<Student> students) {
		super();
		this.id = id;
		this.sportName = sportName;
		this.sportType = sportType;
		this.playerSize = playerSize;
		this.creaetdAt = creaetdAt;
		this.upadtedAt = upadtedAt;
		this.students = students;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSportName() {
		return sportName;
	}

	public void setSportName(String sportName) {
		this.sportName = sportName;
	}

	public String getSportType() {
		return sportType;
	}

	public void setSportType(String sportType) {
		this.sportType = sportType;
	}

	public String getPlayerSize() {
		return playerSize;
	}

	public void setPlayerSize(String playerSize) {
		this.playerSize = playerSize;
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

	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}




	  


}