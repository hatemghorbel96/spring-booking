package com.example.users.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.CreationTimestamp;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Notif {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idNotif;
	
	private String nameuser;
	
	private Long idreviwuser;
	
	private String hotname;
	
	private Integer admin;
	@Column(nullable = true)
	private Integer readed;
	
	private Long hotId;
	
	
	
	@CreationTimestamp
	private Date dateCreation;

	public Long getIdNotif() {
		return idNotif;
	}

	public void setIdNotif(Long idNotif) {
		this.idNotif = idNotif;
	}

	public String getNameuser() {
		return nameuser;
	}

	public void setNameuser(String nameuser) {
		this.nameuser = nameuser;
	}

	public Long getIdreviwuser() {
		return idreviwuser;
	}

	public void setIdreviwuser(Long idreviwuser) {
		this.idreviwuser = idreviwuser;
	}

	public String getHotname() {
		return hotname;
	}

	public void setHotname(String hotname) {
		this.hotname = hotname;
	}

	public Integer getAdmin() {
		return admin;
	}

	public void setAdmin(Integer admin) {
		this.admin = admin;
	}

	public Integer getReaded() {
		return readed;
	}

	public void setReaded(Integer readed) {
		this.readed = readed;
	}

	public Date getDateCreation() {
		return dateCreation;
	}

	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}

	public Long getHotId() {
		return hotId;
	}

	public void setHotId(Long hotId) {
		this.hotId = hotId;
	}
	
	

}
