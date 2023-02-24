package com.example.users.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


import com.example.users.entities.Coupon;

public interface CouponRepository extends JpaRepository<Coupon, Long>{

	 @Query("select c from Coupon c where c.code like %:codein")
	 Coupon gg (@Param("codein") String codein); 
}
