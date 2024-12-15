package com.employee.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.employee.DtoEntities.departmentDto;
import com.employee.entities.Department;
import com.employee.services.DepartmentService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/rest/api/department")
public class DepartmentController {

	@Autowired
	private DepartmentService departmentService;
	
	@PostMapping("/save")
	public Department saveDepartment(@RequestBody Department newDepartment) {
		return departmentService.saveDepartment(newDepartment);
	}
	
	@GetMapping("/getAll")
	public List<departmentDto> getAllDepartments(){
		return departmentService.getAllDepartments();
	}
	
}
