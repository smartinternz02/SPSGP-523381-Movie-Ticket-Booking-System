package com.movie3.movie3.controller;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.neo4j.Neo4jProperties.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.movie3.movie3.entity.Theatre;
import com.movie3.movie3.entity.movie;
import com.movie3.movie3.entity.seatbooking;
import com.movie3.movie3.entity.show;
import com.movie3.movie3.entity.ticket;
import com.movie3.movie3.entity.user;
import com.movie3.movie3.repository.movierepo;
import com.movie3.movie3.repository.theatrerepo;
import com.movie3.movie3.repository.ticketrepo;
import com.movie3.movie3.repository.userrepo;

@Controller
public class ticketcontroller {
	@Autowired
	private ticketrepo trepo;
	
	@Autowired 
	private theatrerepo threpo;
	
	@Autowired
	private userrepo urepo;
	
	@PostMapping("/ticketgen")
	public String ticketgen(ticket t,Model model)
	{
		System.out.println(t.getTheatreid());
	    String theatrename=threpo.findByTheatreid(t.getTheatreid()).getTheatrename();
	    String moviename=threpo.findByTheatreid(t.getTheatreid()).getMov().getMoviename();
	    String location=threpo.findByTheatreid(t.getTheatreid()).getLocation();
	    ticket temp=t;
	    temp.setMoviename(moviename);
	    temp.setTheatrename(theatrename);
	    temp.setLocation(location);
	    model.addAttribute("bookingconform",temp);
		return "theatre";
	}
	
	@PostMapping("/ticketconform")
	public String ticketconform(ticket t,Map<String,Object> model)
	{
		ticket temp=t;
		Theatre trep=threpo.findByTheatrename(t.getTheatrename());
		Long theatreid=trep.getTheatreid();
		Long movieid=trep.getMov().getMovieid();
		Long userid=urepo.findByEmail(t.getEmail()).getId();
		temp.setTheatreid(theatreid);
		temp.setMovieid(movieid);
		temp.setUserid(userid);
		trepo.save(temp);
		List<String> bookedseats=StringConverter.convertStringToList(t.getConformedseats());
		List<seatbooking> l1=trep.getSeats();
		List<show> sh=new ArrayList<>();
		for(int i=0;i<l1.size();i++)
		{
			if(t.getDate()==l1.get(i).getDate())
			{
				sh=l1.get(i).getShows();
				show single=new show();
				for(int j=0;j<sh.size();j++)
				{
					
					if(t.getShowid()==sh.get(j).getShow_id())
					{
						System.out.println(sh.get(j).getShow_id());
						single=sh.get(j);
						int seatsavailable=single.getNo_of_seats();
						List<String> seatsbooked=new ArrayList<>(single.getSeatsbookedlist());
						seatsbooked.addAll(bookedseats);
						int currentseats=seatsavailable-t.getSeatcount();
						single.setNo_of_seats(currentseats);
						single.setSeatsbookedlist(seatsbooked);
						sh.set(i,single);
					}
				}
				l1.get(i).setShows(sh);
			}
		}
		trep.setSeats(l1);
		threpo.save(trep);
		model.put("userid",userid);
		return "ticketbooking_success";
	}
	@GetMapping("/cart/userid/{userid}")
	public String cart(@PathVariable("userid") Long userid,Model model)
	{
		List<ticket> tk=trepo.findByUserid(userid);
		model.addAttribute("tickets",tk);
		return "cart";
	}
}
