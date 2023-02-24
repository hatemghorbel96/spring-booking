package com.example.users.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.users.entities.User;
import com.example.users.repository.UserRepository;
import com.example.users.service.UserService;



@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class UserController {

	@Autowired
	UserRepository userRep;
	@Autowired
	UserService userSer;
	
	@Autowired
	BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@RequestMapping(method = RequestMethod.POST)
	public User createUser(@RequestBody User user) {
	return userSer.saveUser(user);
	}

	@RequestMapping(path = "all", method = RequestMethod.GET)
	public List<User> getAllUsers() {
		return userRep.findAll();
	}
	
	@RequestMapping(method = RequestMethod.PUT)
	public User updateUser(@RequestBody User user) {
	return userSer.updateUser(user);
	}
	
	
	
	@RequestMapping(value="/{id}",method = RequestMethod.GET)
	public User getUserById(@PathVariable("id") Long id) {
	return userSer.getUser(id);
	}
	
	@RequestMapping(value="getUser/{username}",method = RequestMethod.GET)
	public User getUserbyusername(@PathVariable("username") String username) {
	return userSer.findUserByUsername(username);
	}
	
	
	
	
	
	
	
	
	
}
