package com.employee.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.DtoEntities.employeeDto;
import com.employee.entities.Department;
import com.employee.entities.Employee;
import com.employee.entities.JobPosition;
import com.employee.repositories.IDepartmentRepository;
import com.employee.repositories.IEmployeeRepository;
import com.employee.repositories.IJobPositionRepository;


@Service
public class EmployeeService {

	@Autowired
	private IEmployeeRepository employeeRepository;
	
	 @Autowired
	    private IDepartmentRepository departmentRepository;

	    @Autowired
	    private IJobPositionRepository jobPositionRepository;

	    public Employee saveEmployee(Employee newEmployee) {
	        Optional<Department> department = departmentRepository.findById(newEmployee.getDepartment().getId());
	        if (department.isEmpty()) {
	            throw new RuntimeException("Department not found with ID: " + newEmployee.getDepartment().getId());
	        }

	        Optional<JobPosition> jobPosition = jobPositionRepository.findById(newEmployee.getJobPosition().getId());
	        if (jobPosition.isEmpty()) {
	            throw new RuntimeException("Job Position not found with ID: " + newEmployee.getJobPosition().getId());
	        }
	        newEmployee.setDepartment(department.get());
	        newEmployee.setJobPosition(jobPosition.get());
	        return employeeRepository.save(newEmployee);
	    }
	
	public void deleteEmployee(int employeeId) {
		employeeRepository.deleteById(employeeId);
	}
	
	public Employee updateEmployee(int id, Employee employeeDetails) {
		Employee updatedEmployee = employeeRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Employee with ID " + id + " not found"));
		updatedEmployee.setFirstName(employeeDetails.getFirstName());
		updatedEmployee.setLastName(employeeDetails.getLastName());
		updatedEmployee.setDateOfBirth(employeeDetails.getDateOfBirth());
		updatedEmployee.setEmail(employeeDetails.getEmail());
		updatedEmployee.setPhoneNumber(employeeDetails.getPhoneNumber());
		updatedEmployee.setSalary(employeeDetails.getSalary());
		updatedEmployee.setDepartment(employeeDetails.getDepartment());
		updatedEmployee.setJobPosition(employeeDetails.getJobPosition());
		
		return employeeRepository.save(updatedEmployee);
	}
	
	
	public employeeDto getEmployeeById(int employeeId) {
		Optional<Employee> employeeOpt = employeeRepository.findById(employeeId);
		
		if(employeeOpt.isEmpty()) {
			throw new RuntimeException("Employee not found with this ID: " + employeeId);
		}
		Employee emp = employeeOpt.get();
		employeeDto employeeDto = new employeeDto();
		
		employeeDto.setFirstName(emp.getFirstName());
		employeeDto.setLastName(emp.getLastName());
		employeeDto.setDateOfBirth(emp.getDateOfBirth());
		employeeDto.setEmail(emp.getEmail());
		employeeDto.setPhoneNumber(emp.getPhoneNumber());
		employeeDto.setSalary(emp.getSalary());
		return employeeDto;		
		
	}
	
	public List<employeeDto> getAllEmployees(){
		List<Employee> employees = employeeRepository.findAll();
		 List<employeeDto> employeeDtos = new ArrayList<>();

		    for (Employee employee : employees) {
		        employeeDto dto = new employeeDto(
		        		employee.getId(),
		                employee.getFirstName(),
		                employee.getLastName(),
		                employee.getEmail(),
		                employee.getPhoneNumber(),
		                employee.getDateOfBirth(),
		                employee.getSalary()
		        );
		        employeeDtos.add(dto);
		    }

		    return employeeDtos;
		
	}
	
	public List<employeeDto> getEmployeesByDepartmentId(int departmentId){
	
		List<Employee> employees = employeeRepository.findEmployeesByDepartmentId(departmentId);
		List<employeeDto> employeeDtos = new ArrayList<>();
		for (Employee employee : employees) {
	        employeeDto dto = new employeeDto(
	        		employee.getId(),
	                employee.getFirstName(),
	                employee.getLastName(),
	                employee.getEmail(),
	                employee.getPhoneNumber(),
	                employee.getDateOfBirth(),
	                employee.getSalary()
	        );
	        employeeDtos.add(dto);
	    }

	    return employeeDtos;
	}
	
	public List<employeeDto> getEmployeesByJobPositionId(int jobPositionId){
		List<Employee> employees = employeeRepository.findEmployeesByJobPositionId(jobPositionId);
		List<employeeDto> employeeDtos = new ArrayList<>();
		
		for (Employee employee : employees) {
	        employeeDto dto = new employeeDto(
	        		employee.getId(),
	                employee.getFirstName(),
	                employee.getLastName(),
	                employee.getEmail(),
	                employee.getPhoneNumber(),
	                employee.getDateOfBirth(),
	                employee.getSalary()
	        );
	        employeeDtos.add(dto);
	    }

	    return employeeDtos;
	}
	
	public List<employeeDto> findEmployeesBySalaryBetween(double minSalary, double maxSalary){
		List<Employee> employees = employeeRepository.findEmployeesBySalaryBetween(minSalary, maxSalary);
		List<employeeDto> employeeDtos = new ArrayList<>();
			for (Employee employee : employees) {
				employeeDto dto = new employeeDto(
						employee.getId(),
			            employee.getFirstName(),
			            employee.getLastName(),
			            employee.getEmail(),
			            employee.getPhoneNumber(),
			            employee.getDateOfBirth(),
			            employee.getSalary()
			        );
				employeeDtos.add(dto);
			}
			return employeeDtos;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}





























