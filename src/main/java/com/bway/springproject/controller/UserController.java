package com.bway.springproject.controller;

//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bway.springproject.model.User;
import com.bway.springproject.service.UserService;
import com.bway.springproject.utils.VerifyRecaptcha;

import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;


@Slf4j

@Controller
public class UserController {
	
	//private static final Logger log = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	private UserService userService;

	@GetMapping({"/","/login"})
	public String getLogin() {
		return "Login";
	}
	
	@PostMapping("/login")
	public String postLogin(@ModelAttribute User user, Model model, HttpSession session, @RequestParam("g-recaptcha-response") String reCode) throws Exception {
		
		if(VerifyRecaptcha.verify(reCode)) {
			
		
		User usr = userService.userLogin(user.getEmail(), user.getPassword());
		
		if (usr != null) {
			
			log.info("-------------User found/Login Success-------");
			
			session.setAttribute("activeuser", usr);
			session.setMaxInactiveInterval(300);
			//model.addAttribute("fname", usr.getFname());
			return "Home";
		}
		
		else {
			
			log.info("-------------------Login Failed------------------");
			model.addAttribute("message", "Invalid Credentials");
			return "Login";
			
			}
		
	} 
		
		else {
		
		log.info("-------------------Login Failed------------------");
		model.addAttribute("message", "You are not a human");
		return "Login";
		
		}
	}
	
	@GetMapping("/signup")
	public String getSignup() {
		return "Signup";
	}
	
	@PostMapping("/signup")
	public String postSignup(@ModelAttribute User user) {
		
		userService.userSignup(user);
		
		return "login";
	}
	
	@GetMapping("/logout")
	public String getLogout(HttpSession session) {
		session.invalidate();
		log.info("----------------Logout Success-----------------------");
		return "Login";
	}
	
	@GetMapping("/profile")
	public String getProfile() {
		return "Profile";
	}
}