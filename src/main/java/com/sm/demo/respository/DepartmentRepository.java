package com.sm.demo.respository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sm.demo.entity.Department;

public interface DepartmentRepository extends JpaRepository<Department, Long>{
	
}
