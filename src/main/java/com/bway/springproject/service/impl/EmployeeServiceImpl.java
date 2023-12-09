package com.bway.springproject.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bway.springproject.model.Employee;
import com.bway.springproject.repository.EmployeeRepository;
import com.bway.springproject.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService{

	@Autowired
	private EmployeeRepository empRepo;
	@Override
	public void addEmployee(Employee emp) {
		
		empRepo.save(emp);
		
	}

	@Override
	public void deleteEmployee(Long id) {
		
		empRepo.deleteById(id);
		
	}

	@Override
	public void updateEmployee(Employee emp) {
		
		empRepo.save(emp);
		
	}

	@Override
	public Employee getEmployeeById(Long id) {
		
		return empRepo.findById(id).get();
	}

	@Override
	public List<Employee> getAllEmployees() {
		
		return empRepo.findAll();
	}

}
