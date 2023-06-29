package com.movie3.movie3.controller;
import com.movie3.movie3.entity.movie;
import com.movie3.movie3.entity.seatbooking;
import com.movie3.movie3.entity.Theatre;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import com.movie3.movie3.repository.movierepo;




@Controller
public class moviecontroller {
	@Autowired
	private movierepo mrepo;
	
	
	@PostMapping("/movie_search")
	public String moviesearch(movie mov,Theatre thea,Model model)
	{
		movie mov1=mrepo.findByMoviename(mov.getMoviename());
		List<Theatre> l1=mov1.getTheatre();//the theater which displays the searched movies are filtered out here
		List<Theatre> l2=new ArrayList<>();
		String location=thea.getLocation();//entered location is retrieved
		String date=mov.getEnddate();
		String datefinal=date.substring(date.length()-2);
		int d=Integer.parseInt(datefinal);//entered date is converted to two digit integer date
		System.out.println("Entered date is "+d);
		for(int i=0;i<l1.size();i++)
		{
			Theatre temp=new Theatre();
			if(location.equals(l1.get(i).getLocation()))
			{
				temp=l1.get(i);
				List<seatbooking> seatsbooked=l1.get(i).getSeats();
				List<seatbooking> temp2=new ArrayList<>();
				for(int j=0;j<seatsbooked.size();j++)
				{
					if(seatsbooked.get(j).getDate()==d)
					{
						temp2.add(seatsbooked.get(j));
					}
				}
				if(temp2.size()!=0) {
				temp.setSeats(temp2);	
				l2.add(temp);}
			}
		}
		for(int i=0;i<l2.size();i++)
		{
			System.out.println(l2.get(i).getSeats().toString());
		}
		if(l2.size()==0)
		{
			return "notheatres_todisplay";
		}
		else
		{
		model.addAttribute("selectedtheatres",l2);
		return "theatre_display";
		}
		
	}
	@GetMapping("/hd")
	public String hd()
	{
		return "home";
	}
}
