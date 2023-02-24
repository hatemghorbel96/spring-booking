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
import com.example.users.repository.NotifRepository;


@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/notif")
public class NotifController {
	
	@Autowired
	NotifRepository notifRep;
	
	
	@RequestMapping(path="allnotif",method=RequestMethod.GET)
	public List<Notif> getallnotifss()
	{
		return notifRep.findAll();
	}
	
	@RequestMapping(path="getbyusername/{username}",method=RequestMethod.GET)
	public List<Notif> getAllhotelbyid(@PathVariable("username")String username)
	{
		
		return notifRep.findByNameuser(username);
	}
	
	
	@RequestMapping(value = "read/{id}",method = RequestMethod.PUT)
	public ResponseEntity<Notif> makeread(@PathVariable("id") Long id) {
	
	 
		Notif not= notifRep.findById(id).get();
		
		not.setNameuser(not.getNameuser());
		not.setIdreviwuser(not.getIdreviwuser());
		not.setHotname(not.getHotname());
		not.setAdmin(not.getAdmin());
		not.setReaded(1);
		not.setHotId(not.getHotId());
		Notif reded =notifRep.save(not);	
		
		return ResponseEntity.ok().body(reded);
	}

}
