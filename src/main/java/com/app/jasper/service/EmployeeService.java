package com.app.jasper.service;

import java.util.*;

import com.app.jasper.dto.EmployeeDto;

public interface EmployeeService {

	EmployeeDto save(EmployeeDto employeeDto) throws Exception;

    List<EmployeeDto> findAll() throws Exception;

    EmployeeDto findById(Long id) throws Exception;
    
    EmployeeDto update(Long id, EmployeeDto employeeDto) throws Exception;
    
    List<Map<String, Object>> report();
}
