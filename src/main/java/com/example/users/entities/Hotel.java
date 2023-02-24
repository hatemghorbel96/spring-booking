package com.example.users.entities;



import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Hotel {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idHotel;
	
	private String namehotel;
	
	private String city;
	
	private Integer stars;
	
	private Integer nbrooms;
	
	private Integer pricenight;
	
	@Lob
	private String hotellocation;
	
	private String activite;
	
	
	@OneToMany(mappedBy="hotel", cascade = CascadeType.ALL)
	@JsonIgnoreProperties("hotel") 
	 private Set<Tour> tours = new HashSet<>();
	
	@ManyToMany(fetch=FetchType.EAGER,cascade = CascadeType.ALL)
	@JoinTable(name= "hotel_images",
			joinColumns= {
					@JoinColumn(name="idHotel")
					
			},
			
			inverseJoinColumns = {
					@JoinColumn(name="image_id")
			}
		)
	
	
	
	
	private Set<ImageHotel> hotelImages;
	
	 @OneToMany(mappedBy="hotel", cascade = CascadeType.ALL) 
	 @JsonIgnoreProperties("hotel") 
	 private Set<Review> reviews = new HashSet<>();

	public Long getIdHotel() {
		return idHotel;
	}

	public void setIdHotel(Long idHotel) {
		this.idHotel = idHotel;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public Integer getStars() {
		return stars;
	}

	public void setStars(Integer stars) {
		this.stars = stars;
	}

	public String getHotellocation() {
		return hotellocation;
	}

	public void setHotellocation(String hotellocation) {
		this.hotellocation = hotellocation;
	}

	public String getActivite() {
		return activite;
	}

	public void setActivite(String activite) {
		this.activite = activite;
	}
	
	public Set<Tour> getTours() {
		return tours;
	}
	
	public void setTours(Set<Tour> tours) {
		this.tours = tours;
	}

	public Set<ImageHotel> getHotelImages() {
		return hotelImages;
	}

	public void setHotelImages(Set<ImageHotel> hotelImages) {
		this.hotelImages = hotelImages;
	}

	public String getNamehotel() {
		return namehotel;
	}

	public void setNamehotel(String namehotel) {
		this.namehotel = namehotel;
	}

	public Integer getNbrooms() {
		return nbrooms;
	}

	public void setNbrooms(Integer nbrooms) {
		this.nbrooms = nbrooms;
	}

	public Integer getPricenight() {
		return pricenight;
	}

	public void setPricenight(Integer pricenight) {
		this.pricenight = pricenight;
	}
	
	@JsonManagedReference
	public Set<Review> getReviews() {
		return reviews;
	}

	public void setReviews(Set<Review> reviews) {
		this.reviews = reviews;
	}
	
	

}
