package com.yasisv.payroll.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Employeesalary {
	
	@Id
	@GeneratedValue(strategy  = GenerationType.IDENTITY)
	private int sId;
	
	@Column(name = "emp_id")
	private int empId;
	
	@Column(name =  "pf")
	private int pf;
	
	@Column(name = "salary")
	private double salary;
	

//	@OneToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
//	@JoinColumn(name = "emp_id",referencedColumnName = "empId")
//	private Employee emp;
	
	
	public int getsId() {
		return sId;
	}
	public void setsId(int sId) {
		this.sId = sId;
	}
	public int getPf() {
		return pf;
	}
	public void setPf(int pf) {
		this.pf = pf;
	}
	
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
//	public Employee getEmp() {
//		return emp;
//	}
//	public void setEmp(Employee emp) {
//		this.emp = emp;
//	}
	public Integer getEmpId() {
		return empId;
	}
	public void setEmpId(Integer empId) {
		this.empId = empId;
	}
	
	
	
	
	

}
