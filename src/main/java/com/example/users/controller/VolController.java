package com.example.users.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Date;
import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.users.entities.Vol;
import com.example.users.repository.VolRepository;


@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/vol")
public class VolController {
	@Autowired
	VolRepository volRepository;
	
	
	
	@Autowired  ServletContext context;
	
	
	public static String uploadDirectory = System.getProperty("user.dir") + "/src/main/webapp/img";
	
	
	
	@GetMapping(path="/imagevol/{id}")
	public byte[] getPhoto(@PathVariable("id")Long id) throws Exception{
		Vol vol = volRepository.findById(id).get();
		
		return Files.readAllBytes(Paths.get(context.getRealPath("/img/")+vol.getPhoto()));
	}
	
	
	
	
	
	@RequestMapping(path="all",method=RequestMethod.GET)
	public List<Vol> getAllAirline()
	{
		return volRepository.findAll();
	}
	
	@RequestMapping(value="getVol/{id}",method=RequestMethod.GET)
	public Vol getVolById(@PathVariable("id") Long id)
	{
		return volRepository.findById(id).get();
	}
	
	@RequestMapping(method = RequestMethod.POST)
	@ResponseBody
	public String saveVol(@RequestPart("vol")Vol v,@RequestParam("img") MultipartFile file) {
		
		
		String filename=v.getIdVol() + file.getOriginalFilename();
		Path fileNameAndPath =Paths.get(uploadDirectory,filename);
		try {
			Files.write(fileNameAndPath, file.getBytes());
		} catch (IOException e) {
			e.printStackTrace();
		}
		v.setPhoto(filename);
		volRepository.save(v);
		return "Save Data Successfully ! ";
	}
	
	@RequestMapping(value="updatevolbyid/{id}",method = RequestMethod.PUT)
	@ResponseBody
	public String updatevol(@PathVariable("id") Long id,@RequestPart("vol")Vol v,@RequestParam("img") MultipartFile file) {
		
		
		String filename=v.getIdVol() + file.getOriginalFilename();
		Path fileNameAndPath =Paths.get(uploadDirectory,filename);
		try {
			Files.write(fileNameAndPath, file.getBytes());
		} catch (IOException e) {
			e.printStackTrace();
		}
		v.setPhoto(filename);
		volRepository.save(v);
		return "Save Data Successfully ! ";
	}
	
	@RequestMapping(path="date/{datedep}",method=RequestMethod.GET)
	public List<Vol> finbudatetik(@PathVariable("datedep")Date datedep)
	{
		return volRepository.findbydate(datedep);
	}
	
	@RequestMapping(value="VolsByPrix/{maxvol}/{minvol}",method = RequestMethod.GET)
	public List<Vol> findByPrixMaxMin(@PathVariable("maxvol") Integer maxprod,@PathVariable("minvol") Integer minprod) {
	return volRepository.findMaxPrix(maxprod, minprod);
	}

}

