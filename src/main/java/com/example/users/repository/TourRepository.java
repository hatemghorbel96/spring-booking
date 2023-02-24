package com.example.users.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import com.example.users.entities.Tour;

public interface TourRepository extends JpaRepository<Tour, Long>{

}
