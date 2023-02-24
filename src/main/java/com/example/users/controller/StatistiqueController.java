package com.example.users.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.users.entities.Hotel;
import com.example.users.entities.Reservation;
import com.example.users.repository.AirlineRepository;
import com.example.users.repository.CouponRepository;
import com.example.users.repository.HotelRepository;
import com.example.users.repository.ReservationRepository;
import com.example.users.repository.UserRepository;
import com.example.users.repository.VolRepository;

@RestController
@RequestMapping("/stat")
@CrossOrigin (origins = "*")
public class StatistiqueController {
	
	@Autowired
	AirlineRepository airlineRepository;
	
	@Autowired
	CouponRepository couponRepository;
	
	@Autowired
	HotelRepository hotelrepository;
	
	@Autowired
	VolRepository volRepository;
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	ReservationRepository resRepository;
	
	@RequestMapping(path="allHotels",method=RequestMethod.GET)
	public List<Hotel> getAllhotels()
	{
		return hotelrepository.findAll();
	}
	
	@RequestMapping(path="allReservations",method=RequestMethod.GET)
	public List<Reservation> getallReservations()
	{
		return resRepository.findAll();
	}
	
	@RequestMapping(path="totalmoneyRes",method=RequestMethod.GET)
	public Integer Total()
	{
		return resRepository.getsummoney();
	}

}
