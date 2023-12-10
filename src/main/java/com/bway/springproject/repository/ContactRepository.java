package com.bway.springproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bway.springproject.model.Contact;

public interface ContactRepository extends JpaRepository<Contact, Integer>{

	
}
