package com.yasisv.payroll.model;

import com.yasisv.payroll.entity.DeparmentEnum;

public class DepartmentDto {
	
	private int deptId;
	
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
