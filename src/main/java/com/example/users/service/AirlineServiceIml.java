package com.example.users.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.users.entities.Airline;
import com.example.users.repository.AirlineRepository;
@Transactional
@Service
public class AirlineServiceIml implements AirlineService{

	
	@Autowired
	AirlineRepository airlineRepository;
	
	
	@Override
	public List<Airline> getAllAirlines() {
		// TODO Auto-generated method stub
		return airlineRepository.findAll();
	}
}
