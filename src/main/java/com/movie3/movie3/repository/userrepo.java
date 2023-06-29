package com.movie3.movie3.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.movie3.movie3.entity.user;


public interface userrepo extends JpaRepository<user,Long> {
	user findByUsername(String username);
	user findByPassword(String password);
	user findByEmail(String email);
	
}
