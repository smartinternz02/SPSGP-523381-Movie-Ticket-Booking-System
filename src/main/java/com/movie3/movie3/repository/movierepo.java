package com.movie3.movie3.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.movie3.movie3.entity.movie;

public interface movierepo extends JpaRepository<movie,Long>{
	movie findByMoviename(String moviename);
	movie findByMovieid(Long movieid);
}
