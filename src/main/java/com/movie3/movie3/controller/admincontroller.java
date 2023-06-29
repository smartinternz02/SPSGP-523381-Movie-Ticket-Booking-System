package com.movie3.movie3.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.movie3.movie3.repository.adminrepo;

@Controller
public class admincontroller {
	@Autowired
	private adminrepo repo;
	
	
}
