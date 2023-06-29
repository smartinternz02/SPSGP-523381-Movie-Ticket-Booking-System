package com.movie3.movie3.entity;

import java.util.List;

import jakarta.persistence.*;

@Entity
@Table(name="theatre")
public class Theatre {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private Long theatreid;
	@Column(name="theatrename")
	private String theatrename;
	@Column(name="location")
	private String location;
	@Column(name="price")
	private Long price;
	@Column(name="releasedate")
	private String releasedate;
	
	
	
	@ManyToMany
	@JoinTable(name="seat_table",
	joinColumns=@JoinColumn(name="theatreid"),
	inverseJoinColumns=@JoinColumn(name="rowid")
			)
	private List<seatbooking> seats;
	@ManyToOne
	@JoinColumn(name="movieid")
	private movie mov;

	public Theatre() {}
	


	public Theatre(Long theatreid, String theatrename, String location, Long price, String releasedate,
			 List<seatbooking> seats, movie mov) {
		super();
		this.theatreid = theatreid;
		this.theatrename = theatrename;
		this.location = location;
		this.price = price;
		this.releasedate = releasedate;
		this.seats = seats;
		this.mov = mov;
	}






	public List<seatbooking> getSeats() {
		return seats;
	}



	public void setSeats(List<seatbooking> seats) {
		this.seats = seats;
	}



	public String getReleasedate() {
		return releasedate;
	}
	public void setReleasedate(String releasedate) {
		this.releasedate = releasedate;
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


	public String getLocation() {
		return location;
	}


	public void setLocation(String location) {
		this.location = location;
	}


	public Long getPrice() {
		return price;
	}


	public void setPrice(Long price) {
		this.price = price;
	}



	public movie getMov() {
		return mov;
	}


	public void setMov(movie mov) {
		this.mov = mov;
	}
	
	
	
}
