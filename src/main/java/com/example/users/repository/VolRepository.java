package com.example.users.repository;


import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.users.entities.Vol;

public interface VolRepository extends JpaRepository<Vol, Long>{
	
	
	 @Query("select v from Vol v where v.dep = :datedep ")
		List<Vol> findbydate (@Param("datedep") Date datedep); 
	 
	 @Query("select v from Vol v where v.montant <= :maxprod and v.montant >= :minprix")
		List<Vol> findMaxPrix (@Param("maxprod") Integer maxprod,@Param("minprix") Integer minprix); 

}
