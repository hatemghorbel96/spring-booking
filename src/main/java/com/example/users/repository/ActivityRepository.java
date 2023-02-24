package com.example.users.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.users.entities.Activity;


public interface ActivityRepository extends JpaRepository<Activity, Long>{

	List<Activity> findByTourIdTour(Long id);

}
