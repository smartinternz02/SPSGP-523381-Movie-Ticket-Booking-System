package com.movie3.movie3.entity;

import java.util.List;

import jakarta.persistence.*;

@Entity
@Table(name="showtiming")
public class show {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int show_id;
	@Column(name="no_of_seats")
	private int no_of_seats;
	
	@Convert(converter = StringListConverter.class)
	@Column(name="seatsbookedlist")
	private List<String> seatsbookedlist;
	
	@ManyToMany(mappedBy="shows")
	private List<seatbooking> seats;
	
	public show() {}
	
	public List<seatbooking> getSeats() {
		return seats;
	}

	public void setSeats(List<seatbooking> seats) {
		this.seats = seats;
	}
	
	public List<String> getSeatsbookedlist() {
		return seatsbookedlist;
	}

	public void setSeatsbookedlist(List<String> seatsbookedlist) {
		this.seatsbookedlist = seatsbookedlist;
	}

	public show(int show_id, int no_of_seats, List<String> seatsbookedlist, List<seatbooking> seats) {
		super();
		this.show_id = show_id;
		this.no_of_seats = no_of_seats;
		this.seatsbookedlist = seatsbookedlist;
		this.seats = seats;
	}

	public int getShow_id() {
		return show_id;
	}
	public void setShow_id(int show_id) {
		this.show_id = show_id;
	}
	public int getNo_of_seats() {
		return no_of_seats;
	}
	public void setNo_of_seats(int no_of_seats) {
		this.no_of_seats = no_of_seats;
	}
	
	
}
