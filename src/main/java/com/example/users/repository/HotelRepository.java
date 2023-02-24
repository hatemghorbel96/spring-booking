package com.example.users.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.users.entities.Hotel;

public interface HotelRepository extends JpaRepository<Hotel, Long>{

}
