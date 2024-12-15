package com.employee.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.employee.DtoEntities.jobPositionDto;
import com.employee.entities.JobPosition;
import com.employee.services.JobPositionService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/rest/api/jobposition")
public class JobPositionController {

	@Autowired
	private JobPositionService jobPositionService;
	
	@PostMapping("/save")
	public JobPosition saveJobPosition(@RequestBody JobPosition newJobPosition) {
		return jobPositionService.saveJobPosition(newJobPosition);
	}
	
	@GetMapping("/getAll")
	public List<jobPositionDto> geJobPositions(){
		return jobPositionService.getJobPositionDtos();
	}
}
