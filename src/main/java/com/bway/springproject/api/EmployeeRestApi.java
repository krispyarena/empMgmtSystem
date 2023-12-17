package com.bway.springproject.api;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.bway.springproject.model.Employee;
import com.bway.springproject.model.Product;
import com.bway.springproject.repository.ProductRepository;
import com.bway.springproject.service.EmployeeService;

@RestController
public class EmployeeRestApi {

	@Autowired
	private EmployeeService empService;
	
	@Autowired
	private ProductRepository productRepo;
	
	@GetMapping("/api/employee/list")
	public List<Employee> getAll() {
		
		return empService.getAllEmployees();
	}
	
	@GetMapping("/api/employee/{id}")
	public Employee getOne(@PathVariable Long id) {
		return empService.getEmployeeById(id);
	}
	
	@PostMapping("/api/employee/add")
	public String addEmployee(@RequestBody Employee emp) {
		empService.addEmployee(emp);
		return "success";
	}
	
	@DeleteMapping("/api/employee/delete/{id}")
	public String deleteEmployee(@PathVariable Long id) {
		empService.deleteEmployee(id);
		
		return "Deletion Successful";
	}
	
	@PutMapping("/api/employee/update")
	public String updateEmployee(@RequestBody Employee emp) {
		
		empService.updateEmployee(emp);
		
		return "Update Successful";
	}
	
	@GetMapping("/api/employee/j2o")
	public String jsonToObject() {
		
		RestTemplate temp = new RestTemplate();
		Employee e = temp.getForObject("http://localhost:8080/api/employee/12", Employee.class);
		return "FirstName = "+e.getFname();
	}
	
	@GetMapping("/api/employee/ja2oa")
	public String jsonArrayToObjArray() {
		
		RestTemplate rt = new RestTemplate();
		Employee[] emps = rt.getForObject("http://localhost:8080/api/employee/list", Employee[].class);
		return "FirstName = "+ emps[1].getFname();
	}
	
	@GetMapping("/api/employee/loadProduct")
	public String loadProducts() {
		
		RestTemplate rt = new RestTemplate();
		Product[] products = rt.getForObject("https://fakestoreapi.com/products", Product[].class);
		productRepo.saveAll(Arrays.asList(products));
		return "Success";
	
	}
}