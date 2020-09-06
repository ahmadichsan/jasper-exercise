package com.app.jasper.dto;

import java.math.BigDecimal;
import java.util.Date;

public class EmployeeDto {

    private String name;
    private String gender;
    private Date dob;
    private String city;
    private BigDecimal salary;
    
    public EmployeeDto() {
    	
    }

	public EmployeeDto(String name, String gender, Date dob, String city, BigDecimal salary) {
		super();
		this.name = name;
		this.gender = gender;
		this.dob = dob;
		this.city = city;
		this.salary = salary;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public BigDecimal getSalary() {
		return salary;
	}

	public void setSalary(BigDecimal salary) {
		this.salary = salary;
	}
}
