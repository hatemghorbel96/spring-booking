package com.example.users.controller;

import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.users.entities.Hotel;
import com.example.users.entities.ImageModel;
import com.example.users.entities.Tour;
import com.example.users.repository.TourRepository;

@RestController
@RequestMapping("/tour")
@CrossOrigin (origins = "*")
public class TourController {
	
	@Autowired
	TourRepository tourepository;
	
	@RequestMapping(method = RequestMethod.POST,consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
	public Tour addtour(@RequestPart("tour") Tour tour,@RequestPart("imageFile")MultipartFile[]file) {
	//return 
		
		try {
			Set<ImageModel> image = uploadImage(file);
			tour.setTourImages(image);
			return tourepository.save(tour);
		}catch(Exception e)
			{
				System.out.println(e.getMessage());
				return null;
			}
	}
	
	public Set<ImageModel> uploadImage(MultipartFile[] multipartFiles) throws IOException {
		Set<ImageModel> imageModels = new HashSet<>();
		
		for (MultipartFile file: multipartFiles) {
			ImageModel imageModel = new ImageModel(
					null, file.getOriginalFilename(),
					file.getContentType(),
					file.getBytes()
					);
					imageModels.add(imageModel);
		}
		
		return imageModels;
	}
	
	@RequestMapping(path="all",method=RequestMethod.GET)
	public List<Tour> getAlltours()
	{
		return tourepository.findAll();
	}
	
	@RequestMapping(path="getbyid/{id}",method=RequestMethod.GET)
	public Tour getAllhotelbyid(@PathVariable("id")Long id)
	{
		return tourepository.findById(id).get();
	}

}
