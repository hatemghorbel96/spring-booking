package com.example.users.controller;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.users.dto.ReservationDTO;
import com.example.users.entities.CanceledRes;
import com.example.users.entities.Persone;
import com.example.users.entities.Reservation;
import com.example.users.entities.User;
import com.example.users.entities.Vol;
import com.example.users.repository.CancelResRepository;
import com.example.users.repository.ReservationRepository;
import com.example.users.repository.UserRepository;
import com.example.users.repository.VolRepository;



@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/reservation")
public class ReservationController {
	
	@Autowired
	VolRepository volRepository;
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	ReservationRepository resRepository;
	
	@Autowired
	CancelResRepository cancledResRepository;
	
	@RequestMapping(value = "add/{id}/{username}",method = RequestMethod.POST)
	public void addres(@PathVariable("id") Long id,@PathVariable("username") String username,@RequestBody Reservation r) {
	
	User u = userRepository.findByUsername(username);
	Vol v= volRepository.findById(id).get();
	 r.setUser(u);
	 r.setVol(v);
	 Integer totalrommhotel=r.getVol().getTour().getHotel().getNbrooms();
	 Integer room = r.getNbrooms();
	 r.getVol().getTour().getHotel().setNbrooms(totalrommhotel-room);	 
	 Integer sum= (r.getNb()*v.getMontant())+(r.getExtra())+room;
	 if (r.getCouponon()==null) {
		 r.setMontantTotal(sum);
	 }else {
		 r.setMontantTotal(sum-r.getCouponon());
	 }
	
	 v.setNbr(v.getNbp()-r.getNb());
		Set<Persone> persones = r.getPersones();
		persones.forEach(item -> r.add(item)
								
				);	
	
		r.setCheckin(v.getDep());
		r.setCheckout(v.getFin());
	 volRepository.save(v);
	 resRepository.save(r);	 
	}
	
	@RequestMapping(value = "annule/{id}",method = RequestMethod.DELETE)
	public void annuleres(@PathVariable("id") Long id) {
	
	// annule vol
	Reservation res= resRepository.findById(id).get();
	Integer nb= res.getNb();
	
	Vol v= res.getVol();
	Long resvolid = v.getIdVol();
	Vol thisvol = volRepository.findById(resvolid).get();
	Integer nbr=thisvol.getNbr();
	Integer s = nbr+nb;
	thisvol.setNbr(s);
	// annule hotel rooms
	Integer nbRooms= res.getNbrooms();
	Integer totalrommhotel=res.getVol().getTour().getHotel().getNbrooms();
	Integer sumromms=totalrommhotel+nbRooms;
	res.getVol().getTour().getHotel().setNbrooms(sumromms);
	//cancel
	CanceledRes cancel= new CanceledRes();
	cancel.setNbroomcancled(nbRooms);
	cancel.setPersonnename(res.getUser().getUsername());
	cancel.setVolplaces(nb);
	cancledResRepository.save(cancel);
	resRepository.deleteById(id);
	volRepository.save(thisvol);
		 
	}
	
	@RequestMapping(path="mybooking/{username}",method=RequestMethod.GET)
	public List<ReservationDTO> getmybooking(@PathVariable("username") String username)
	{
		return resRepository.findByUserUsername(username);
	}
	
	@RequestMapping(path="all",method=RequestMethod.GET)
	public List<Reservation> getAllres()
	{
		return resRepository.findAll();
	}
	
	@RequestMapping(path="getcancledRes",method=RequestMethod.GET)
	public List<CanceledRes> getcancledRes()
	{
		return cancledResRepository.findAll();
	}
	
	@RequestMapping(path="numbercancled",method=RequestMethod.GET)
	public Integer numbercancled()
	{	
		return cancledResRepository.getnb();
	}
	
	@RequestMapping(path="checkintoday",method=RequestMethod.GET)
	public Integer funtodaycheckin()
	{	
		return resRepository.checkintoday();
	}
	
	@RequestMapping(path="incomingcheckin",method=RequestMethod.GET)
	public Integer funIncomingcheckin()
	{	
		return resRepository.incomingcheckin();
	}
	
	@RequestMapping(path="checkouttoday",method=RequestMethod.GET)
	public Integer funrescheckout()
	{	
		return resRepository.checkouttoday();
	}
	
	@RequestMapping(path="checkoutoutgoing",method=RequestMethod.GET)
	public Integer funoutgoingcheckout()
	{	
		return resRepository.outgoingcheckout();
	}
	
	@RequestMapping(path="todayres",method=RequestMethod.GET)
	public Integer todayres()
	{	
		return resRepository.todayreservation();
	}
	
	//earning
	@RequestMapping(path="dailyearning",method=RequestMethod.GET)
	public Integer avgdailyearning()
	{	
		return resRepository.dailyearning();
	}
	
	@RequestMapping(path="monthlyearning",method=RequestMethod.GET)
	public Integer funmontly()
	{	
		return resRepository.monthlyearning();
	}

}
