package com.bway.springproject.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bway.springproject.model.User;
import com.bway.springproject.repository.UserRepository;
import com.bway.springproject.service.UserService;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepository userRepo;
	
	@Override
	public void userSignup(User user) {
		
		userRepo.save(user);
		
	}

	@Override
	public User userLogin(String email, String psw) {
		
		return userRepo.findByEmailAndPassword(email, psw);
	}

	
}
