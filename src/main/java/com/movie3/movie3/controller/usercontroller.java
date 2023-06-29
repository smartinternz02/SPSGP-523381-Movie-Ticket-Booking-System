package com.movie3.movie3.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.movie3.movie3.entity.user;
import com.movie3.movie3.repository.userrepo;

@Controller
public class usercontroller {
	
	@Autowired
	private userrepo repo;
	
	@GetMapping("")
	public String registrationpage()
	{
		return "index";
	}
	@GetMapping("/register")
	public String showRegistrationForm(Model model) {
	    model.addAttribute("user", new user());
	    return "signup_form";
	}
	@PostMapping("/process_register")
	public String processRegister(user us) {
		user u1=repo.findByEmail(us.getEmail());
		if(u1!=null)
		{
			return "user_present";
		}
		else
		{
	    repo.save(us);
	    return "register_success";
		}
	}
	@PostMapping("/login_process")
	public String processlogin(user us)
	{
		String username=null,password=null;
		username=us.getUsername();
		password=us.getPassword();
		user u1=repo.findByUsername(username);
		if(u1!=null)
		{
			if(password.equals(u1.getPassword()))
				return "home";
			else
				return "error_login";
		}
		return "error_login";
	}
	@GetMapping("/login")
	public String loginpage()
	{
		return "login";
	}
	@GetMapping("/forgot_password")
	public String forgotpassword()
	{
		return "forgot";
	}
	@PostMapping("/reset_process")
	public String resetpassword(user us)
	{
		user u1=repo.findByEmail(us.getEmail());
		if(u1!=null)
		{
			u1.setPassword(us.getPassword());
			repo.save(u1);
			return "password_resetsuccess";
		}
		return "email_notfound";
	}
	
}
