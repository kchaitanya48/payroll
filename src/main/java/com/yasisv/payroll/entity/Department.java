package com.yasisv.payroll.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;



@Entity
public class Department {
	@Id
	@GeneratedValue(strategy  = GenerationType.IDENTITY)
	private int deptId;
	@Column
	private DeparmentEnum deptName;
	public int getDeptId() {
		return deptId;
	}
	public void setDeptId(int deptId) {
		this.deptId = deptId;
	}
	public DeparmentEnum getDeptName() {
		return deptName;
	}
	public void setDeptName(DeparmentEnum deptName) {
		this.deptName = deptName;
	}

	
}
