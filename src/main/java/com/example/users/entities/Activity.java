package com.example.users.entities;

import java.util.Set;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Activity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idActivity;
	private String title;
	private String description;
	
	@Lob
	private String longdescription;
	
	
	
	@ManyToOne
	@JsonIgnoreProperties("activity")
	private Tour tour;



	public Long getIdActivity() {
		return idActivity;
	}



	public void setIdActivity(Long idActivity) {
		this.idActivity = idActivity;
	}



	public String getTitle() {
		return title;
	}



	public void setTitle(String title) {
		this.title = title;
	}



	public String getDescription() {
		return description;
	}



	public void setDescription(String description) {
		this.description = description;
	}


	@JsonBackReference
	public Tour getTour() {
		return tour;
	}


	@JsonBackReference
	public void setTour(Tour tour) {
		this.tour = tour;
	}



	public String getLongdescription() {
		return longdescription;
	}



	public void setLongdescription(String longdescription) {
		this.longdescription = longdescription;
	}
	
	
	
	

	
	

}
