package com.bway.springproject.service;

import java.util.List;

import com.bway.springproject.model.Department;


public interface DepartmentService {

	void addDept(Department dept);
	
	void updateDept(Department dept);
	
	void deleteDept(int id);
	
	Department getDeptById(int id);
	
	List<Department> getAllDepts();
}
