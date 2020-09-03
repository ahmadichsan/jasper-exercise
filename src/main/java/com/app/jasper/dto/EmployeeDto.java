package com.app.jasper.dto;

import java.util.Date;

public class EmployeeDto {

    private String name;
    private String gender;
    private Date dob;
    private String city;
    
    public EmployeeDto() {
    	
    }

	public EmployeeDto(String name, String gender, Date dob, String city) {
		super();
		this.name = name;
		this.gender = gender;
		this.dob = dob;
		this.city = city;
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
}
