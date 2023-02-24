package com.example.users.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


import com.example.users.entities.Review;

public interface ReviewRepository extends JpaRepository<Review, Long>{

	List<Review> findByHotelIdHotel(Long idhotel);

}
