package com.example.users.entities;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Vol {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idVol;
	private String volFrom;
	private String volTo;
	
	private Date dep;

	private Date fin;
	
	@Column(nullable = true)
	private Date retour;

	@Column(nullable = true)
	private Date retourhome;
	@Column(nullable = true)
	private String photo;
	private String classtype;
	private Integer nbp;
	private Integer nbr;
	private Integer montant;
	private Integer Refundable;
	private String stops;
	
	
	@ManyToOne	
	private Airline airline;
	
	
	 
	 @OneToMany(mappedBy="vol", cascade = CascadeType.ALL)
	
	 private Set<Reservation> reservations = new HashSet<>();
	 
	
	@ManyToOne	
	@JsonIgnoreProperties("tour")
	@JoinColumn(nullable = true)
	private Tour tour;

	
	

	public Long getIdVol() {
		return idVol;
	}



	public void setIdVol(Long idVol) {
		this.idVol = idVol;
	}



	public String getVolFrom() {
		return volFrom;
	}



	public void setVolFrom(String volFrom) {
		this.volFrom = volFrom;
	}



	public String getVolTo() {
		return volTo;
	}



	public void setVolTo(String volTo) {
		this.volTo = volTo;
	}



	public Date getDep() {
		return dep;
	}



	public void setDep(Date dep) {
		this.dep = dep;
	}



	public Date getFin() {
		return fin;
	}



	public void setFin(Date fin) {
		this.fin = fin;
	}



	public Date getRetour() {
		return retour;
	}



	public void setRetour(Date retour) {
		this.retour = retour;
	}



	public Date getRetourhome() {
		return retourhome;
	}



	public void setRetourhome(Date retourhome) {
		this.retourhome = retourhome;
	}



	public String getPhoto() {
		return photo;
	}



	public void setPhoto(String photo) {
		this.photo = photo;
	}



	public String getClasstype() {
		return classtype;
	}



	public void setClasstype(String classtype) {
		this.classtype = classtype;
	}



	public Integer getNbp() {
		return nbp;
	}



	public void setNbp(Integer nbp) {
		this.nbp = nbp;
	}



	public Integer getNbr() {
		return nbr;
	}



	public void setNbr(Integer nbr) {
		this.nbr = nbr;
	}



	public Integer getMontant() {
		return montant;
	}



	public void setMontant(Integer montant) {
		this.montant = montant;
	}



	public String getStops() {
		return stops;
	}



	public void setStops(String stops) {
		this.stops = stops;
	}



	public Airline getAirline() {
		return airline;
	}



	public void setAirline(Airline airline) {
		this.airline = airline;
	}


	@JsonManagedReference
	public Set<Reservation> getReservations() {
		return reservations;
	}



	public void setReservations(Set<Reservation> reservations) {
		this.reservations = reservations;
	}


	
	public Tour getTour() {
		return tour;
	}


	
	public void setTour(Tour tour) {
		this.tour = tour;
	}



	public Integer getRefundable() {
		return Refundable;
	}



	public void setRefundable(Integer refundable) {
		Refundable = refundable;
	}
	 
	 

}
