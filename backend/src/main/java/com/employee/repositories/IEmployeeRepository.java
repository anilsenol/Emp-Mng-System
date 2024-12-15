package com.employee.repositories;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.employee.entities.Employee;

@Repository
public interface IEmployeeRepository extends JpaRepository<Employee, Integer>{

	List<Employee> findEmployeesByDepartmentId(int id);
	List<Employee> findEmployeesByJobPositionId(int id);
	
	@Query("SELECT e FROM Employee e WHERE e.salary BETWEEN :minSalary AND :maxSalary")
	List<Employee> findEmployeesBySalaryBetween(@Param("minSalary") double minSalary,@Param("maxSalary") double maxSalary);
	
}
