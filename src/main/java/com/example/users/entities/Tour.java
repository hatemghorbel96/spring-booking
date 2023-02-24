package com.example.users.entities;


import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Tour {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idTour;
	
	private Integer tourdays;
	
	private String tourname;
	
	private String description;
	
	private String info;
	
	private Integer tourMontant;
	
	
	@OneToMany
	 	
	private Set<Activity> activitys = new HashSet<>();
	
	@OneToMany(mappedBy="tour", cascade = CascadeType.ALL)
	@JsonIgnoreProperties("tour") 
	private Set<Vol> vols = new HashSet<>();
	
	@ManyToOne	
	@JsonIgnoreProperties("tour")
	private Hotel hotel;
	
	 
	
	@ManyToMany(fetch=FetchType.EAGER,cascade = CascadeType.ALL)
	@JoinTable(name= "tour_images",
			joinColumns= {
					@JoinColumn(name="idTour")
					
			},
			
			inverseJoinColumns = {
					@JoinColumn(name="image_id")
			}
		)
	
	
	private Set<ImageModel> tourImages;

	public Long getIdTour() {
		return idTour;
	}

	public void setIdTour(Long idTour) {
		this.idTour = idTour;
	}

	public Integer getTourdays() {
		return tourdays;
	}

	public void setTourdays(Integer tourdays) {
		this.tourdays = tourdays;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}
	
	public Set<Vol> getVols() {
		return vols;
	}
	
	public void setVols(Set<Vol> vols) {
		this.vols = vols;
	}
	
	public Hotel getHotel() {
		return hotel;
	}
	
	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}

	public Set<ImageModel> getTourImages() {
		return tourImages;
	}

	public void setTourImages(Set<ImageModel> tourImages) {
		this.tourImages = tourImages;
	}

	public String getTourname() {
		return tourname;
	}

	public void setTourname(String tourname) {
		this.tourname = tourname;
	}

	public Integer getTourMontant() {
		return tourMontant;
	}

	public void setTourMontant(Integer tourMontant) {
		this.tourMontant = tourMontant;
	}
	@JsonManagedReference
	public Set<Activity> getActivitys() {
		return activitys;
	}
	@JsonManagedReference
	public void setActivitys(Set<Activity> activitys) {
		this.activitys = activitys;
	}

	
	
	

}
