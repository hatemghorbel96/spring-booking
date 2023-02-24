package com.example.users.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.users.entities.Airline;
import com.example.users.repository.AirlineRepository;
import com.example.users.service.AirlineService;



@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/airline")
public class AirlineController {
	
	@Autowired
	AirlineRepository airlineRepository;
	
	@Autowired
	AirlineService airlineService;
	
	@Autowired  ServletContext context;
	
	
	public static String uploadDirectory = System.getProperty("user.dir") + "/src/main/webapp/img";
	
	
	
	@GetMapping(path="/imageAirline/{id}")
	public byte[] getPhoto(@PathVariable("id")Long id) throws Exception{
		Airline airline = airlineRepository.findById(id).get();
		
		return Files.readAllBytes(Paths.get(context.getRealPath("/img/")+airline.getLogoAirline()));
	}
	
	
	
	
	
	@RequestMapping(path="all",method=RequestMethod.GET)
	public List<Airline> getAllAirline()
	{
		return airlineService.getAllAirlines();
	}
	
	@RequestMapping(value="getAirline/{id}",method=RequestMethod.GET)
	public Airline getAirlineById(@PathVariable("id") Long id)
	{
		return airlineRepository.findById(id).get();
	}
	
	@RequestMapping(method = RequestMethod.POST)
	@ResponseBody
	public String saveAirline(Airline s,@RequestParam("img") MultipartFile file) {
		
		
		String filename=s.getIdairline() + file.getOriginalFilename();
		Path fileNameAndPath =Paths.get(uploadDirectory,filename);
		try {
			Files.write(fileNameAndPath, file.getBytes());
		} catch (IOException e) {
			e.printStackTrace();
		}
		s.setLogoAirline(filename);
		airlineRepository.save(s);
		return "Save Data Successfully ! ";
	}

}
