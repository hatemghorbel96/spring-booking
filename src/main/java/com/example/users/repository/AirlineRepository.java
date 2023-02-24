package com.example.users.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.users.entities.Airline;


public interface AirlineRepository extends JpaRepository<Airline, Long>{

}
