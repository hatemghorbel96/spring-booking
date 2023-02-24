package com.example.users.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Replay {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idReplay;
	private String content;
	
	@CreationTimestamp
	private Date dateCreation;
	
	@ManyToOne	
	@JsonIgnoreProperties("review")
	private Review review;

	public Long getIdReplay() {
		return idReplay;
	}

	public void setIdReplay(Long idReplay) {
		this.idReplay = idReplay;
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

	public Review getReview() {
		return review;
	}

	public void setReview(Review review) {
		this.review = review;
	}
	
	
}
