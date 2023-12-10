package com.bway.springproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

//import com.bway.springproject.model.Department;
import com.bway.springproject.model.Employee;
import com.bway.springproject.service.DepartmentService;
import com.bway.springproject.service.EmployeeService;

import jakarta.servlet.http.HttpSession;

@Controller
public class EmployeeController {

	@Autowired
	private EmployeeService empService;
	
	@Autowired
	private DepartmentService deptService;
	
	@GetMapping("/employee")
	public String getEmployee(Model model, HttpSession session) {
		
		if (session.getAttribute("activeuser")==null) {
			return "Login";
		}
		
		model.addAttribute("dList", deptService.getAllDepts());
		
		return "EmployeeForm";
	}
	
	@PostMapping("/employee")
	public String postEmployee(@ModelAttribute Employee emp) {
		
		empService.addEmployee(emp);
		
		return "EmployeeForm";
	}
	
	@GetMapping("/employeeList")
	public String getEmployeeList(Model model, HttpSession session) {
		
		if(session.getAttribute("activeuser")==null) {
			return "Login";
		}
		
		model.addAttribute("eList", empService.getAllEmployees());
		return "EmployeeListForm";
	}
	
	@GetMapping("/employee/delete")
	public String delete(@RequestParam Long id, HttpSession session) {
		
		if(session.getAttribute("activeuser")==null) {
			return "Login";
		}
		
		empService.deleteEmployee(id);
		return "redirect:/employeeList";
	}
	
	@GetMapping("/employee/edit")
	public String edit(@RequestParam Long id, Model model, HttpSession session) {
		
		if (session.getAttribute("activeuser") == null ) {
			return "Login";
		}
		
		model.addAttribute("empObject", empService.getEmployeeById(id));
		return "EmployeeEditForm";
	}
	
	@PostMapping("/employee/update")
	public String update(@ModelAttribute Employee emp) {
		empService.updateEmployee(emp);
		return "redirect:/employeeList";
	}
}
