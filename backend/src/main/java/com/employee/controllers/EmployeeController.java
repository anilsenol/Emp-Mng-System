package com.employee.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.employee.DtoEntities.employeeDto;
import com.employee.entities.Employee;
import com.employee.services.EmployeeService;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/rest/api/employee")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;
	
	@PostMapping(path = "/save")
	public Employee savEmployee(@RequestBody Employee newEmployee) {
		return employeeService.saveEmployee(newEmployee);
	}
	
	@DeleteMapping(path = "/delete")
	public void deleteEmployee(@RequestParam("employeeId") int employeeId) {
		employeeService.deleteEmployee(employeeId);
	}
	
	@PutMapping("/update/{id}")
	public Employee updateEmployee(@PathVariable int id, @RequestBody Employee updatedEmployee) {
		return employeeService.updateEmployee(id, updatedEmployee);
	}
	
	@GetMapping(path = "/get/{id}")
	public employeeDto getEmployeeById(@PathVariable int id) {
		return employeeService.getEmployeeById(id);
	}
	
	@GetMapping(path = "/getAll")
	public List<employeeDto> getAllEmployees(){
		return employeeService.getAllEmployees();
	}
	
	@GetMapping(path = "/by-department")
	public List<employeeDto> getEmployeesByDepartmentId(@RequestParam int departmentId){
		return employeeService.getEmployeesByDepartmentId(departmentId);
	}
	
	@GetMapping(path = "/by-jobPosition")
	public List<employeeDto> getEmployeesByJobPositionId(@RequestParam int jobPositionId){
		return employeeService.getEmployeesByJobPositionId(jobPositionId);
	}
	
	@GetMapping(path = "/by-salaryRange")
	public List<employeeDto> findEmployeesBySalaryBetween(@RequestParam double minSalary, @RequestParam double maxSalary){
		return employeeService.findEmployeesBySalaryBetween(minSalary, maxSalary);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
