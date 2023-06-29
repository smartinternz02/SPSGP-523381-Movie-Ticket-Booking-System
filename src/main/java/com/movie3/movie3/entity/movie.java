package com.movie3.movie3.entity;

import java.util.List;


import jakarta.persistence.*;

@Entity
@Table(name="movie")
public class movie {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private Long movieid;
	@Column(name="moviename")
	private String moviename;
	@Column(name="enddate")
	private String enddate;
	
	@OneToMany(mappedBy="mov")
	private List<Theatre> theatre;
	
	public movie() {}
	
	public List<Theatre> getTheatre() {
		return theatre;
	}

	public void setTheatre(List<Theatre> theatre) {
		this.theatre = theatre;
	}

	public movie(Long movieid, String moviename, String enddate, List<Theatre> theatre) {
		super();
		this.movieid = movieid;
		this.moviename = moviename;
		this.enddate = enddate;
		this.theatre = theatre;
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
	public String getEnddate() {
		return enddate;
	}
	public void setEnddate(String enddate) {
		this.enddate = enddate;
	}
	
	
}
