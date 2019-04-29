package com.app.jasper.model;

import java.math.*;
import java.util.*;

import javax.persistence.*;

@Entity
@Table(name = "employee")
public class Employee {

	@Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "name", nullable = false)
    private String name;
    
    @Column(name = "gender", nullable = false)
    private String gender;
    
    @Column(name = "dob", nullable = false)
    private Date dob;
    
    @Column(name = "address", nullable = false)
    private String address;
    
    @Column(name = "salary", nullable = false)
    private BigDecimal salary;
    
    public Employee() {
    	
    }

	public Employee(Long id, String name, String gender, Date dob, String address, BigDecimal salary) {
		super();
		this.id = id;
		this.name = name;
		this.gender = gender;
		this.dob = dob;
		this.address = address;
		this.salary = salary;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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
