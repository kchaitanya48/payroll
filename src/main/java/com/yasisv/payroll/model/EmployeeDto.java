package com.yasisv.payroll.model;

import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;



public class EmployeeDto {
	
	private int empId;

	private String empName;
	
	private List<AddressDto> empAddress;

	
	
	
	
	
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public List<AddressDto> getEmpAddress() {
		return empAddress;
	}
	public void setEmpAddress(List<AddressDto> empAddress) {
		this.empAddress = empAddress;
	}
	



}
