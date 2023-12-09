package com.bway.springproject.service;

import org.springframework.stereotype.Service;

import com.bway.springproject.model.User;

@Service
public interface UserService {
	
	void userSignup(User user);
	
	User userLogin(String email, String psw);

}
