package com.yasisv.payroll.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yasisv.payroll.entity.Department;
import com.yasisv.payroll.repository.DepartmentRepository;

@Service
public class DepartmentService {

	@Autowired
	private DepartmentRepository departmentRepository;
	
	@Transactional
	public void addDepartment(Department department) {
		departmentRepository.save(department);
	}
}
