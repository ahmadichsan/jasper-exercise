package com.app.jasper.serviceImpl;

import java.util.*;

import javax.transaction.*;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

import com.app.jasper.dao.EmployeeDao;
import com.app.jasper.dto.EmployeeDto;
import com.app.jasper.model.Employee;
import com.app.jasper.service.EmployeeService;

@Service("employeeService")
@Transactional(rollbackOn = {Exception.class})
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	EmployeeDao employeeDao;
	
	@Override
	public EmployeeDto save(EmployeeDto employeeDto) throws Exception {
		Employee newEmployee = new Employee();
		try {
	    	BeanUtils.copyProperties(employeeDto, newEmployee);
	    	employeeDao.save(newEmployee);
	    } catch (Exception e) {
	    	throw new Exception(e);
	    }
        return employeeDto;
	}

	@Override
	public List<EmployeeDto> findAll() throws Exception {
		List<Employee> list = new ArrayList<>();
		List<EmployeeDto> employeeListDto = new ArrayList<>();
		
		try {
			employeeDao.findAll().iterator().forEachRemaining(list::add);
			
			for (Employee listEmp : list) {
		        EmployeeDto employeeDto = new EmployeeDto();
				BeanUtils.copyProperties(listEmp, employeeDto);
		        employeeListDto.add(employeeDto);
		    }
		} catch (Exception e) {
			throw new Exception(e);
		}
		return employeeListDto;
	}

	@Override
	public EmployeeDto findById(Long id) throws Exception {
		Employee employee = new Employee();
		EmployeeDto employeeDto = new EmployeeDto();
		try {
			employee = employeeDao.findById(id).get();
			BeanUtils.copyProperties(employee, employeeDto);
		} catch (Exception e) {
			throw new Exception(e);
		}
		return employeeDto;
	}

	@Override
	public EmployeeDto update(Long id, EmployeeDto employeeDto) throws Exception {
		Employee employee;
		try {
			employee = employeeDao.findById(id).get();
			BeanUtils.copyProperties(employeeDto, employee);
			employeeDao.save(employee);
		} catch (Exception e) {
			throw new Exception(e);
		}
		return employeeDto;
	}

	@Override
	public List<Map<String, Object>> report() {
		List<Map<String, Object>> result = new ArrayList<Map<String, Object>>();
		for (Employee employee : employeeDao.findAll()) {
			Map<String, Object> item = new HashMap<String, Object>();
			item.put("id", employee.getId());
			item.put("name", employee.getName());
			item.put("gender", employee.getGender());
			item.put("dob", employee.getDob());
			item.put("address", employee.getAddress());
			item.put("salary", employee.getSalary());
			result.add(item);
		}
		return result;
	}
}
