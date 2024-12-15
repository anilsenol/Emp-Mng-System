package com.employee.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.employee.entities.JobPosition;

@Repository
public interface IJobPositionRepository extends JpaRepository<JobPosition, Integer>{

}
