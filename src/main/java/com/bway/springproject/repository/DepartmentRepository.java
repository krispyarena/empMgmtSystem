package com.bway.springproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bway.springproject.model.Department;

public interface DepartmentRepository extends JpaRepository<Department, Integer>{

}
