package com.employee.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.employee.entities.Department;


@Repository
public interface IDepartmentRepository extends JpaRepository<Department, Integer>{

}
