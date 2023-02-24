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
import com.example.users.entities.ImageHotel;
import com.example.users.repository.HotelRepository;


@RestController
@RequestMapping("/hotel")
@CrossOrigin (origins = "*")
public class HotelController {
	
	@Autowired
	HotelRepository hotelrepository;
	
	@RequestMapping(method = RequestMethod.POST,consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
	public Hotel addhotel(@RequestPart("hotel") Hotel hotel,@RequestPart("imageFile")MultipartFile[]file) {
	//return 
		
		try {
			Set<ImageHotel> image = uploadImage(file);
			hotel.setHotelImages(image);
			return hotelrepository.save(hotel);
		}catch(Exception e)
			{
				System.out.println(e.getMessage());
				return null;
			}
	}
	
	public Set<ImageHotel> uploadImage(MultipartFile[] multipartFiles) throws IOException {
		Set<ImageHotel> imageHotels = new HashSet<>();
		
		for (MultipartFile file: multipartFiles) {
			ImageHotel imageHotel = new ImageHotel(
					null, file.getOriginalFilename(),
					file.getContentType(),
					file.getBytes()
					);
					imageHotels.add(imageHotel);
		}
		
		return imageHotels;
	}
	
	@RequestMapping(path="all",method=RequestMethod.GET)
	public List<Hotel> getAllhotels()
	{
		return hotelrepository.findAll();
	}
	
	@RequestMapping(path="getbyid/{id}",method=RequestMethod.GET)
	public Hotel getAllhotelbyid(@PathVariable("id")Long id)
	{
		return hotelrepository.findById(id).get();
	}
	
	

}
