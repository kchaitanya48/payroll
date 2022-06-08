package com.yasisv.payroll.entity;

import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;


@Entity
public class Employee {
	
	@Id
	@GeneratedValue(strategy  = GenerationType.IDENTITY)
	private int empId;
	@Column
	private String empName;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name ="emp_id",referencedColumnName  = "empId")
	private List<Address> empAddress;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "dept_id", referencedColumnName = "deptId")
	private Department department;
	
	
	
	
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
	public List<Address> getEmpAddress() {
		return empAddress;
	}
	public void setEmpAddress(List<Address> empAddress) {
		this.empAddress = empAddress;
	}
	public Department getDepartment() {
		return department;
	}
	public void setDepartment(Department department) {
		this.department = department;
	}
	
	



}
