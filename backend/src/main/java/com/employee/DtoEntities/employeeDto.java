package com.employee.DtoEntities;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter@Setter@NoArgsConstructor@AllArgsConstructor
public class employeeDto {
	
	private int id;
	
	private String firstName;
	
	
	private String lastName;
	
	
	private String email;
	
	
	private String phoneNumber;
	

	private Date dateOfBirth;
	
	
	private double salary;
	
}
