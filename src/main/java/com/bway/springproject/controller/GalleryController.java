package com.bway.springproject.controller;

import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.bway.springproject.repository.ProductRepository;

import jakarta.servlet.http.HttpSession;

@Controller
public class GalleryController {
	
	@Autowired
	private ProductRepository prodRepo;

	@GetMapping("/gallery")
	public String getGalleryForm(Model model, HttpSession session) {
		
		if (session.getAttribute("activeuser")==null) {
			return "Login";
		}
		
		String[] imgNames = new File("src/main/resources/static/images").list();
		
		model.addAttribute("imgNameList", imgNames);
		
		return "GalleryForm";
	}
	
	@GetMapping("/productGallery")
	public String getProductGallery(Model model) {
		
		model.addAttribute("pImageList", prodRepo.findAll());
		
		return "ProductGallery";
	}
}
