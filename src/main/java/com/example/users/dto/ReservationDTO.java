package com.example.users.dto;

import java.util.Date;



import com.example.users.entities.User;
import com.example.users.entities.Vol;


import lombok.Data;


public class ReservationDTO {
	
	  private Long id;	  
	  	private Integer nb;	  	
	  	private Integer montantTotal;	  
	  	private Integer extra;	  			
	  	private Integer couponon;			
	  	private Integer nbrooms;				
	  	private Integer montantExtraRoom;		
		private Date dateCreated;			
		private Date checkin;	
		private Date checkout;			 
		private Vol vol;	  
		private User user;
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
		public ReservationDTO(Long id, Integer nb, Integer montantTotal, Integer extra, Integer couponon,
				Integer nbrooms, Integer montantExtraRoom, Date dateCreated, Date checkin, Date checkout, Vol vol,
				User user) {
			super();
			this.id = id;
			this.nb = nb;
			this.montantTotal = montantTotal;
			this.extra = extra;
			this.couponon = couponon;
			this.nbrooms = nbrooms;
			this.montantExtraRoom = montantExtraRoom;
			this.dateCreated = dateCreated;
			this.checkin = checkin;
			this.checkout = checkout;
			this.vol = vol;
			this.user = user;
		}
		
		

}
