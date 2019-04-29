package com.app.jasper.controller;

import java.io.*;
import java.util.*;

import javax.servlet.http.*;

import org.springframework.beans.factory.annotation.*;
import org.springframework.http.*;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;

import com.app.jasper.dto.EmployeeDto;
import com.app.jasper.service.EmployeeService;

import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.*;

@Controller("employeeController")
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	@RequestMapping(value = "/all", method = RequestMethod.GET)
	public List<EmployeeDto> findAll() throws Exception {
		return employeeService.findAll();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public EmployeeDto findById(@PathVariable(value = "id") Long id) throws Exception {
		return employeeService.findById(id);
	}

	@RequestMapping(value = "/regis", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> save(@RequestBody EmployeeDto employeeDto) {
		try {
			if (!"MALE".equals(employeeDto.getGender()) && !"FEMALE".equals(employeeDto.getGender())) {
				return ResponseEntity.badRequest().body("unknown keyword for the gender");
			}
			employeeService.save(employeeDto);
			return ResponseEntity.ok().body("insert done");
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}
	
	@RequestMapping(value = "/edit/{id}", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> update(@PathVariable(value = "id") Long id, @RequestBody EmployeeDto employeeDto) {
		try {
			employeeService.update(id, employeeDto);
			return ResponseEntity.ok().body("update done");
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}
	
	@RequestMapping(value = "/report", method = RequestMethod.GET)
	public void report(HttpServletResponse response) throws Exception {
		JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(employeeService.report());
		InputStream inputStream = this.getClass().getResourceAsStream("/reports/employee.jrxml");
		JasperReport jasperReport = JasperCompileManager.compileReport(inputStream);
		JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, null, dataSource);
		
		response.setContentType("application/x-pdf");
	    response.setHeader("Content-disposition", "inline; filename=employeeReport.pdf");

	    final OutputStream outStream = response.getOutputStream();
	    JasperExportManager.exportReportToPdfStream(jasperPrint, outStream);
	}
}
