package com.movie3.movie3.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.movie3.movie3.entity.Theatre;

public interface theatrerepo extends JpaRepository<Theatre,Long>{

	Theatre findByTheatreid(Long theatreid);

	Theatre findByTheatrename(String theatrename);

}
