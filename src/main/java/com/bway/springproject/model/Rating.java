package com.bway.springproject.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data

@Entity
@Table(name="rating")
public class Rating {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private double rate;
	private int count;
}
