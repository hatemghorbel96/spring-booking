package com.example.users.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.users.config.ProductEventListener;
import com.example.users.entities.Notif;
import com.example.users.entities.Replay;
import com.example.users.entities.Review;
import com.example.users.repository.NotifRepository;
import com.example.users.repository.ReplayRepository;
import com.example.users.repository.ReviewRepository;

@RestController
@RequestMapping("/replay")
@CrossOrigin (origins = "*")
public class ReplayController {
	
	@Autowired
	ReplayRepository replayrepository;
	
	@Autowired
	ReviewRepository reviwRepository;
	
	@Autowired
	NotifRepository notifRepository;
	
	 @Autowired
	    private ProductEventListener pe;
	
	@RequestMapping(value = "addreplay/{id}",method = RequestMethod.POST)
	public void addReplay(@PathVariable("id") Long id,@RequestBody Replay r) {
		
	 Review rev= reviwRepository.findById(id).get();
	 r.setReview(rev);
		Notif n = new Notif();
		n.setAdmin(1);
		n.setHotname(r.getReview().getHotel().getNamehotel());
		n.setNameuser(r.getReview().getUser().getUsername());
		n.setIdreviwuser(r.getReview().getIdrev());
		n.setReaded(0);
		n.setHotId(r.getReview().getHotel().getIdHotel());
		
		notifRepository.save(n);
		pe.handleProductChangeEvent(n);
	 replayrepository.save(r);	 
	}

}
