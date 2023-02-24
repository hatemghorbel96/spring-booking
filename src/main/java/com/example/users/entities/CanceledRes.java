package com.example.users.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class CanceledRes {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idCancel;	
	
	private Integer nbroomcancled;
	private String personnename;
	@Temporal(TemporalType.DATE)
	@CreationTimestamp
	private Date dateCreated;
	
	private Integer volplaces;
}
