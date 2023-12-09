package com.bway.springproject.service;

import java.util.List;

import com.bway.springproject.model.Employee;

public interface EmployeeService {

	void addEmployee(Employee emp);
	
	void deleteEmployee(Long id);
	
	void updateEmployee(Employee emp);
	
	Employee getEmployeeById(Long id);
	
	List<Employee> getAllEmployees();
}
