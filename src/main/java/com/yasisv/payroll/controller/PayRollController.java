package com.yasisv.payroll.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.yasisv.payroll.entity.Employeesalary;
import com.yasisv.payroll.mapper.MapStructMapper;
import com.yasisv.payroll.model.EmployeePayroll;
import com.yasisv.payroll.model.EmployeeSalaryDto;
import com.yasisv.payroll.service.PayRollService;

@RestController
public class PayRollController {
	
	@Autowired
	PayRollService payRollService;
	
	
	@Autowired
	MapStructMapper mapStructMapper;
	
	@PostMapping("/empSalary")
	public EmployeeSalaryDto saveEmployeePay(@RequestBody EmployeeSalaryDto employeeSalaryDto) {
		Employeesalary employeesalary= payRollService.save(mapStructMapper.EmployeeSalaryDtoToEmployeeSalary(employeeSalaryDto));
		return mapStructMapper.employeeSalaryToEmployeeSalaryDto(employeesalary);
	}
	
	@GetMapping("/empSalary/{empId}")
	public EmployeePayroll getEmployeePay(@PathVariable Integer empId) {
		return  payRollService.getEmployeeSalaryDetails(empId);
	}

}
