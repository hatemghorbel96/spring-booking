package com.example.users.entities;



import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Persone {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idpersone;
	
	private String titre;
	private String firstname;
	private String lastname;
	private String datebirth;
	private String nationality;
	private Integer passport;
	private String country;
	private String passworddateout;
	@ManyToOne	
 	@JsonIgnoreProperties("persone")
	private Reservation reservation;
	public Long getIdpersone() {
		return idpersone;
	}
	public void setIdpersone(Long idpersone) {
		this.idpersone = idpersone;
	}
	public String getTitre() {
		return titre;
	}
	public void setTitre(String titre) {
		this.titre = titre;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getDatebirth() {
		return datebirth;
	}
	public void setDatebirth(String datebirth) {
		this.datebirth = datebirth;
	}
	public String getNationality() {
		return nationality;
	}
	public void setNationality(String nationality) {
		this.nationality = nationality;
	}
	public Integer getPassport() {
		return passport;
	}
	public void setPassport(Integer passport) {
		this.passport = passport;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getPassworddateout() {
		return passworddateout;
	}
	public void setPassworddateout(String passworddateout) {
		this.passworddateout = passworddateout;
	}
	 @JsonBackReference
	public Reservation getReservation() {
		return reservation;
	}
	 @JsonBackReference
	public void setReservation(Reservation reservation) {
		this.reservation = reservation;
	}
	
	

}
