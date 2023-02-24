package com.example.users.repository;

import java.time.LocalDate;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.users.entities.CanceledRes;


public interface CancelResRepository  extends JpaRepository<CanceledRes, Long>{
	
	
	 @Query("select count(r) from CanceledRes r where r.dateCreated = CURRENT_DATE")
		Integer getnb (); 
	 
	 
}
