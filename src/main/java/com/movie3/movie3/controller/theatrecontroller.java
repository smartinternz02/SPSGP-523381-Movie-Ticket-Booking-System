package com.movie3.movie3.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.movie3.movie3.entity.Theatre;
import com.movie3.movie3.entity.seatbooking;
import com.movie3.movie3.entity.show;
import com.movie3.movie3.repository.theatrerepo;


@Controller
public class theatrecontroller {
	@Autowired
	private theatrerepo trepo;


    @GetMapping("/seatselection/theatreid/{theatre_id}/showid/{show_id}/date/{dateint}")
	public String process(@PathVariable("theatre_id") Long theatreid,@PathVariable("show_id") int showid,@PathVariable("dateint") int date,Map<String,Object> model)
	{
		Theatre temp=trepo.findByTheatreid(theatreid);
	    List<seatbooking> l1=temp.getSeats();
	    seatbooking st=new seatbooking();
	    show sh=new show();
	    List<show> l2=new ArrayList<>();
	    for(int i=0;i<l1.size();i++)
	    {
	    	if(date==l1.get(i).getDate())
	    	{
	    		st=l1.get(i);
	    		l2=l1.get(i).getShows();
	    	}
	    }
	    
	    for(int i=0;i<l2.size();i++)
	    {
	    	if(showid==l2.get(i).getShow_id())
	    	{
	    		sh=l2.get(i);
	    	}
	    		
	    }
	    st.setShows(new ArrayList<show>(Arrays.asList(sh)));
	    temp.setSeats(new ArrayList<seatbooking>(Arrays.asList(st)));
	    model.put("showid",sh.getShow_id());
	    model.put("availableseats",sh.getNo_of_seats());
	    model.put("bookedseats",sh.getSeatsbookedlist());
	    model.put("Theatreid",temp.getTheatreid());
	    model.put("date",st.getDate());
		return "seat_selection";
	}
    
	
}
