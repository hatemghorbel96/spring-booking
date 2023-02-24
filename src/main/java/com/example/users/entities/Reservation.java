package com.example.users.entities;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Reservation {
	
	  @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name="id")
	    private Long id;
	  
	  	private Integer nb;
	  	
	  	private Integer montantTotal;
	  	@Column(nullable = true)
	  	private Integer extra;
	  	
		@Column(nullable = true)
	  	private Integer couponon;
		
		@Column(nullable = true)
	  	private Integer nbrooms;
		
		@Column(nullable = true)
	  	private Integer montantExtraRoom;
	  	
		@Column(nullable = true)
		@JsonFormat(pattern = "dd.MM.YYYY")
		@CreationTimestamp
		private Date dateCreated;
		
		@Column(nullable = true)
		private Date checkin;
		
		@Column(nullable = true)
		private Date checkout;
		
		
	  	
	  	@ManyToOne	
	 
		private Vol vol;
	  	
	  	@ManyToOne	
	  	@JsonIgnoreProperties("user")
		private User user;
	  	
	  	 @OneToMany(mappedBy="reservation", fetch = FetchType.LAZY,cascade = {CascadeType.PERSIST,CascadeType.MERGE,CascadeType.REMOVE})	 
		 private Set<Persone> persones = new HashSet<>();
	  	 
	  	 public void add(Persone item) {

		        if (item != null) {
		            if (persones == null) {
		            	persones= new HashSet<>();
		            }

		            persones.add(item);
		            item.setReservation(this);
		        }
		    }
	  	 
	  	 

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public Integer getNb() {
			return nb;
		}

		public void setNb(Integer nb) {
			this.nb = nb;
		}

		public Integer getMontantTotal() {
			return montantTotal;
		}

		public void setMontantTotal(Integer montantTotal) {
			this.montantTotal = montantTotal;
		}
		 @JsonBackReference
		public Vol getVol() {
			return vol;
		}

		public void setVol(Vol vol) {
			this.vol = vol;
		}

		public User getUser() {
			return user;
		}

		public void setUser(User user) {
			this.user = user;
		}


		@JsonManagedReference
		public Set<Persone> getPersones() {
			return persones;
		}


		@JsonManagedReference
		public void setPersones(Set<Persone> persones) {
			this.persones = persones;
		}



		public Integer getExtra() {
			return extra;
		}



		public void setExtra(Integer extra) {
			this.extra = extra;
		}



		public Integer getCouponon() {
			return couponon;
		}



		public void setCouponon(Integer couponon) {
			this.couponon = couponon;
		}



		public Integer getNbrooms() {
			return nbrooms;
		}



		public void setNbrooms(Integer nbrooms) {
			this.nbrooms = nbrooms;
		}



		public Integer getMontantExtraRoom() {
			return montantExtraRoom;
		}



		public void setMontantExtraRoom(Integer montantExtraRoom) {
			this.montantExtraRoom = montantExtraRoom;
		}



		public Date getDateCreated() {
			return dateCreated;
		}



		public void setDateCreated(Date dateCreated) {
			this.dateCreated = dateCreated;
		}



		public Date getCheckin() {
			return checkin;
		}



		public void setCheckin(Date checkin) {
			this.checkin = checkin;
		}



		public Date getCheckout() {
			return checkout;
		}



		public void setCheckout(Date checkout) {
			this.checkout = checkout;
		}
	  	
	  	

}
