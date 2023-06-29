package com.movie3.movie3.entity;

import java.util.List;

import jakarta.persistence.*;

@Entity
@Table(name="seatbooking")
public class seatbooking {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="rowid")
	private Long rowid;
	@Column(name="date")
	private int date;
	@Column(name="theatreid")
	private int theatreid;
	@ManyToMany(mappedBy="seats")
	private List<Theatre> theatres;
	
	@ManyToMany
	@JoinTable(name="show_table",
	joinColumns=@JoinColumn(name="rowid"),
	inverseJoinColumns=@JoinColumn(name="showid")
			)
	private List<show> shows;
	
	public seatbooking() {}

	

	public List<show> getShows() {
		return shows;
	}



	public void setShows(List<show> shows) {
		this.shows = shows;
	}



	



	public int getTheatreid() {
		return theatreid;
	}



	public void setTheatreid(int theatreid) {
		this.theatreid = theatreid;
	}



	public seatbooking(Long rowid, int date, int theatreid, List<Theatre> theatres, List<show> shows) {
		super();
		this.rowid = rowid;
		this.date = date;
		this.theatreid = theatreid;
		this.theatres = theatres;
		this.shows = shows;
	}



	public Long getRowid() {
		return rowid;
	}

	public void setRowid(Long rowid) {
		this.rowid = rowid;
	}

	public int getDate() {
		return date;
	}

	public void setDate(int date) {
		this.date = date;
	}

	public List<Theatre> getTheatres() {
		return theatres;
	}

	public void setTheatres(List<Theatre> theatres) {
		this.theatres = theatres;
	}
	
	
	
}
