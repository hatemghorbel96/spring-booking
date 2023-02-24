package com.example.users.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.users.dto.ReservationDTO;
import com.example.users.entities.Reservation;

public interface ReservationRepository extends JpaRepository<Reservation, Long>{
	
	 @Query("select SUM(montantTotal) from Reservation r")
		Integer getsummoney (); 
	 
	 @Query("select count(r) from Reservation r where r.checkin = CURRENT_DATE")
		Integer checkintoday ();
	 
	 @Query("select count(r) from Reservation r where r.checkin < CURRENT_DATE")
		Integer incomingcheckin ();
	 
	 @Query("select count(r) from Reservation r where r.checkin = CURRENT_DATE")
		Integer checkouttoday ();
	 
	 @Query("select count(r) from Reservation r where r.checkout < CURRENT_DATE")
		Integer outgoingcheckout ();
	 
	 @Query("select count(r) from Reservation r where r.dateCreated = CURRENT_DATE")
		Integer todayreservation ();
	 
	 @Query("select AVG(montantTotal) from Reservation r where r.dateCreated = CURRENT_DATE")
		Integer dailyearning ();
	 
	 @Query("select SUM(montantTotal) from Reservation r where r.dateCreated = CURRENT_DATE")
		Integer monthlyearning ();
	 
	 //@Query("SELECT r FROM Reservation r JOIN user u ON u.userId = r.id where u.username =:usernametap")
	 //@Query("select r from Reservation r where r.user.username = usernametap")
	// @Query("select r from Reservation r inner join User u on u.user_id=r.user.user_id where u.username=:usernametap  ")
	List<ReservationDTO> findByUserUsername(String username);

	
	 

}
