package com.example.users.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.users.config.ProductEventListener;
import com.example.users.entities.Hotel;
import com.example.users.entities.Notif;
import com.example.users.entities.Review;
import com.example.users.entities.User;
import com.example.users.repository.HotelRepository;
import com.example.users.repository.NotifRepository;
import com.example.users.repository.ReviewRepository;
import com.example.users.repository.UserRepository;


@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/review")
public class ReviewController {
	
	@Autowired
	ReviewRepository reviwRepository;
	
	@Autowired
	UserRepository userRep;
	
	@Autowired
	NotifRepository notifRepository;
	
	 @Autowired
	    private ProductEventListener pe;
	@Autowired
	HotelRepository hotelrepository;
	
	@RequestMapping(value = "add/{id}/{username}",method = RequestMethod.POST)
	public void addReview(@PathVariable("id") Long id,@PathVariable("username") String username,@RequestBody Review r) {
	
	 User u = userRep.findByUsername(username);
	 Hotel h= hotelrepository.findById(id).get();
	 	r.setUser(u);
		r.setHotel(h);
		r.setIdrev(r.getHotel().getIdHotel());
		Notif n = new Notif();
		n.setAdmin(0);
		n.setHotname(r.getHotel().getNamehotel());
		n.setNameuser(u.getUsername());
		n.setIdreviwuser(r.getIdrev());
		n.setReaded(0);
		n.setHotId(r.getHotel().getIdHotel());
		notifRepository.save(n);
		reviwRepository.save(r);	
		pe.handleProductChangeEvent(n);
	}
	
	@RequestMapping(value = "update/{id}",method = RequestMethod.PUT)
	public ResponseEntity<Review> updateReview(@PathVariable("id") Long id,@RequestBody Review r) {
	
	 
		Review getReview= reviwRepository.findById(id).get();
		
		getReview.setIdrev(getReview.getHotel().getIdHotel());
		getReview.setHotel(getReview.getHotel());
		getReview.setUser(getReview.getUser());
		getReview.setContent(r.getContent());
		getReview.setDateCreation(null);
		Review updatedReviw =reviwRepository.save(getReview);	
		
		return ResponseEntity.ok().body(updatedReviw);
	}
	
	@RequestMapping(value="/{idhotel}",method = RequestMethod.GET)
	public List<Review> getReviewByHotelId(@PathVariable("idhotel") Long idhotel) {
	return reviwRepository.findByHotelIdHotel(idhotel);
	}
	
	@RequestMapping(value="/get/{id}",method = RequestMethod.GET)
	public Review getReviewById(@PathVariable("id") Long id) {
	return reviwRepository.findById(id).get();
	}
	
	@RequestMapping(value="/delete/{id}",method = RequestMethod.DELETE)
	public void deletebyid(@PathVariable("id") Long id) {
		reviwRepository.deleteById(id);
	}
	
	@RequestMapping(path="allrev",method=RequestMethod.GET)
	public List<Review> getallReviews()
	{
		return reviwRepository.findAll();
	}
	
	

}
