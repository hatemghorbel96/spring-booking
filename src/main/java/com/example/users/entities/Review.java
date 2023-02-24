package com.example.users.entities;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Review {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idReview;
	private int rating;
	private String content;
	
	@Column(nullable = true)
	private Long idrev;
	
	
	@CreationTimestamp
	private Date dateCreation;
	
	 @UpdateTimestamp
	    private Date UpdatedAt;
		
		@ManyToOne
		
		private User user;
		
		@ManyToOne	
		@JsonIgnoreProperties("hotel")
		private Hotel hotel;
		
		
		 @OneToMany(mappedBy="review", cascade = CascadeType.ALL) 
		 @JsonIgnoreProperties("review") 
		 private Set<Replay> replays = new HashSet<>();
		

		public int getRating() {
			return rating;
		}

		public void setRating(int rating) {
			this.rating = rating;
		}

		public String getContent() {
			return content;
		}

		public void setContent(String content) {
			this.content = content;
		}

		public Date getDateCreation() {
			return dateCreation;
		}

		public void setDateCreation(Date dateCreation) {
			this.dateCreation = dateCreation;
		}

		public Date getUpdatedAt() {
			return UpdatedAt;
		}

		public void setUpdatedAt(Date updatedAt) {
			UpdatedAt = updatedAt;
		}
		
		public User getUser() {
			return user;
		}

		public void setUser(User user) {
			this.user = user;
		}
		 @JsonBackReference
		public Hotel getHotel() {
			return hotel;
		}

		public void setHotel(Hotel hotel) {
			this.hotel = hotel;
		}

		public Long getIdReview() {
			return idReview;
		}

		public void setIdReview(Long idReview) {
			this.idReview = idReview;
		}

		public Long getIdrev() {
			return idrev;
		}

		public void setIdrev(Long idrev) {
			this.idrev = idrev;
		}

		public Set<Replay> getReplays() {
			return replays;
		}

		public void setReplays(Set<Replay> replays) {
			this.replays = replays;
		}
		
		

}
