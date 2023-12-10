package com.bway.springproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.bway.springproject.model.User;
import com.bway.springproject.service.UserService;

import jakarta.servlet.http.HttpSession;

@Controller
public class UserController {
	
	@Autowired
	private UserService userService;

	@GetMapping({"/","/login"})
	public String getLogin() {
		return "Login";
	}
	
	@PostMapping("/login")
	public String postLogin(@ModelAttribute User user, Model model, HttpSession session) {
		
		User usr = userService.userLogin(user.getEmail(), user.getPassword());
		
		if (usr != null) {
			
			session.setAttribute("activeuser", usr);
			session.setMaxInactiveInterval(300);
			//model.addAttribute("fname", usr.getFname());
			return "Home";
		}
		model.addAttribute("message", "Invalid Credentials");
		return "Login";
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
		return "Login";
	}
	
	@GetMapping("/profile")
	public String getProfile() {
		return "Profile";
	}
}
