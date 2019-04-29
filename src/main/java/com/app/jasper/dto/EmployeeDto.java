package com.app.jasper.dto;

import java.math.BigDecimal;
import java.util.Date;

public class EmployeeDto {

    private String name;
    private String gender;
    private Date dob;
    private String address;
    private BigDecimal salary;
    
    public EmployeeDto() {
    	
    }

	public EmployeeDto(String name, String gender, Date dob, String address, BigDecimal salary) {
		super();
		this.name = name;
		this.gender = gender;
		this.dob = dob;
		this.address = address;
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public BigDecimal getSalary() {
		return salary;
	}

	public void setSalary(BigDecimal salary) {
		this.salary = salary;
	}
}
