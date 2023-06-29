package com.movie3.movie3.entity;

import java.util.List;

import jakarta.persistence.*;

@Entity
@Table(name="ticket")

public class ticket {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int ticketid;
	private int showid;
	private Long theatreid;
	private String theatrename;
	private Long movieid;
	private String moviename;
	private Long userid;
	private String email;
	private int date;
	private int seatcount;
	
	private String location;
	private String conformedseats;
	public ticket() {}
	
	public ticket(int ticketid, int showid, Long theatreid, String theatrename, Long movieid, String moviename,
			Long userid, int date, int seatcount, String conformedseats,String email,String location) {
		super();
		this.ticketid = ticketid;
		this.showid = showid;
		this.theatreid = theatreid;
		this.theatrename = theatrename;
		this.movieid = movieid;
		this.moviename = moviename;
		this.userid = userid;
		this.date = date;
		this.seatcount = seatcount;
		this.conformedseats = conformedseats;
		this.email=email;
		this.location=location;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getTicketid() {
		return ticketid;
	}

	public void setTicketid(int ticketid) {
		this.ticketid = ticketid;
	}

	public int getShowid() {
		return showid;
	}

	public void setShowid(int showid) {
		this.showid = showid;
	}

	public Long getTheatreid() {
		return theatreid;
	}

	public void setTheatreid(Long theatreid) {
		this.theatreid = theatreid;
	}

	public String getTheatrename() {
		return theatrename;
	}

	public void setTheatrename(String theatrename) {
		this.theatrename = theatrename;
	}

	public Long getMovieid() {
		return movieid;
	}

	public void setMovieid(Long movieid) {
		this.movieid = movieid;
	}

	public String getMoviename() {
		return moviename;
	}

	public void setMoviename(String moviename) {
		this.moviename = moviename;
	}

	public Long getUserid() {
		return userid;
	}

	public void setUserid(Long userid) {
		this.userid = userid;
	}

	public int getDate() {
		return date;
	}

	public void setDate(int date) {
		this.date = date;
	}

	public int getSeatcount() {
		return seatcount;
	}

	public void setSeatcount(int seatcount) {
		this.seatcount = seatcount;
	}

	public String getConformedseats() {
		return conformedseats;
	}

	public void setConformedseats(String conformedseats) {
		this.conformedseats = conformedseats;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	
}
