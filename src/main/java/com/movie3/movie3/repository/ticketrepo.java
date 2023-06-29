package com.movie3.movie3.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.movie3.movie3.entity.ticket;

public interface ticketrepo extends JpaRepository<ticket,Integer>{

	List<ticket> findByUserid(Long userid);

}
