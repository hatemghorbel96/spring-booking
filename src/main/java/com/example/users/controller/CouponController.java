package com.example.users.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.example.users.entities.Coupon;
import com.example.users.repository.CouponRepository;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/coupon")
public class CouponController {
	
	@Autowired
	CouponRepository couponRepository;
	
	@RequestMapping(path="all",method=RequestMethod.GET)
	public List<Coupon> getAllCoupon()
	{
		return couponRepository.findAll();
	}
	
	@RequestMapping(value="getcoupon/{id}",method=RequestMethod.GET)
	public Coupon getCouponById(@PathVariable("id") Long id)
	{
		return couponRepository.findById(id).get();
	}
	
	@RequestMapping(method = RequestMethod.POST)
	@ResponseBody
	public String saveCoupon(@RequestBody Coupon c) {
	
		couponRepository.save(c);
		return "coupon added Successfully ! ";
	}
	@RequestMapping(path="checkcoupon/{codein}",method=RequestMethod.GET)
	public Coupon checkcoupon(@PathVariable("codein") String codein) {
		Coupon g=couponRepository.gg(codein);
		if (g==null) {
			return null;
		} else {
			return g;
		}
		
	}

}
