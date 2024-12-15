package com.employee.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.DtoEntities.jobPositionDto;
import com.employee.entities.Department;
import com.employee.entities.JobPosition;
import com.employee.repositories.IDepartmentRepository;
import com.employee.repositories.IJobPositionRepository;

@Service
public class JobPositionService {

	@Autowired
	private IJobPositionRepository jobPositionRepository;
	
	@Autowired
	private IDepartmentRepository departmentRepository;
	
	public JobPosition saveJobPosition(JobPosition jobPosition) {
        Department department = departmentRepository.findById(jobPosition.getDepartment().getId())
            .orElseThrow(() -> new RuntimeException("Department not found with id: " + jobPosition.getDepartment().getId()));
                jobPosition.setDepartment(department);
                return jobPositionRepository.save(jobPosition);
    }
	
	
	public List<jobPositionDto> getJobPositionDtos(){
		List<JobPosition> jobPositions = jobPositionRepository.findAll();
		List<jobPositionDto> jobPositionDtos = new ArrayList<>();
		
		for(JobPosition jobPosition : jobPositions) {
			jobPositionDto dto = new jobPositionDto(
					jobPosition.getId(),
					jobPosition.getTitle());
					
			jobPositionDtos.add(dto);
		}
		return jobPositionDtos;
		
		
	}
}
