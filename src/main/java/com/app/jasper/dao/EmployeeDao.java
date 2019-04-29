package com.app.jasper.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.jasper.model.Employee;

@Repository("employeeDao")
public interface EmployeeDao extends JpaRepository<Employee, Long> {
	
}
