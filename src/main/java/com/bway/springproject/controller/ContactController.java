package com.bway.springproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.bway.springproject.model.Contact;
import com.bway.springproject.utils.MailUtil;

import jakarta.servlet.http.HttpSession;

@Controller
public class ContactController {

	@Autowired
	private MailUtil mailUtil;
	
	@GetMapping("/contact")
	public String getContact(HttpSession session) {
		
		if (session.getAttribute("activeuser")==null) {
			return "Login";
		}
		
		return "ContactForm";
	}
	
	@PostMapping("/contact")
	public String postContact(@ModelAttribute Contact contact) {
		
		mailUtil.sendEmail(contact.getToEmail(), contact.getSubject(), contact.getMessage());
		return "ContactForm";
	}
}
