package com.example.users.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.users.entities.Activity;
import com.example.users.entities.Tour;
import com.example.users.entities.User;
import com.example.users.repository.ActivityRepository;
import com.example.users.repository.CouponRepository;
import com.example.users.repository.TourRepository;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/activity")
public class ActivityController {
	
	@Autowired
	ActivityRepository activityRepository;
	@Autowired
	TourRepository tourepository;
	
	@RequestMapping(value="/{id}",method = RequestMethod.POST)
	public Activity createActivity(@RequestBody Activity activity,@PathVariable("id")Long id) {
	Tour tourid=tourepository.findById(id).get();	
	activity.setTour(tourid);
	return activityRepository.save(activity);
	}

	@RequestMapping(path = "all", method = RequestMethod.GET)
	public List<Activity> getAllActivitys() {
		return activityRepository.findAll();
	}
	
	@RequestMapping(method = RequestMethod.PUT)
	public Activity updateUser(@RequestBody Activity activity) {
	return activityRepository.save(activity);
	}
	
	@RequestMapping(value="/getactivity/{id}",method = RequestMethod.GET)
	public Activity getActivityById(@PathVariable("id") Long id) {
	return activityRepository.findById(id).get();
	}
	
	@RequestMapping(value="/actTourId/{id}",method = RequestMethod.GET)
	public List<Activity> getActivitiesByTourIr(@PathVariable("id") Long id) {
	return activityRepository.findByTourIdTour(id);
	}

}
