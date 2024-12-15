package com.employee.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.DtoEntities.departmentDto;
import com.employee.entities.Department;
import com.employee.repositories.IDepartmentRepository;

@Service
public class DepartmentService {

	@Autowired
	private IDepartmentRepository departmentRepository;
	
	public Department saveDepartment(Department newDepartment) {
		return departmentRepository.save(newDepartment);
	}
	
	public List<departmentDto> getAllDepartments(){
		List<Department> departments = departmentRepository.findAll();
		List<departmentDto> depDto = new ArrayList<>();
		
		for(Department depDetail : departments) {
			departmentDto dto = new departmentDto(
					depDetail.getId(),
					depDetail.getDepartment());
			depDto.add(dto);
		}
		return depDto;
	}
	
	
	
}
