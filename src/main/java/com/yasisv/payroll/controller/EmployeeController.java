package com.yasisv.payroll.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.yasisv.payroll.entity.Employee;
import com.yasisv.payroll.mapper.EmployeeMapper;
import com.yasisv.payroll.mapper.MapStructMapper;
import com.yasisv.payroll.model.AddressDto;
import com.yasisv.payroll.model.EmployeeDto;
import com.yasisv.payroll.service.EmployeeService;

@RestController

public class EmployeeController {

	@Autowired
	EmployeeService service;

	@Autowired
	private MapStructMapper mapstructMapper;

	@Autowired
	private EmployeeMapper employeeMapper;
	
	@GetMapping("/employee/{empId}")
	public EmployeeDto getEmployee(@PathVariable Integer empId) {
		
		return employeeMapper.employeeToEmployeeDto(service.getEmployee(empId));
	}

	@PostMapping("/employee")
	public EmployeeDto saveDetails(@RequestBody EmployeeDto empDto) {

		Employee emp=service.saveEmployee(employeeMapper.employeeDtoToEmployee(empDto));
		return employeeMapper.employeeToEmployeeDto(emp);
	}

	@PutMapping("/employee")
	public void updateEmployee(@RequestBody EmployeeDto empDto) {
		service.updateEmployee(employeeMapper.employeeDtoToEmployee(empDto));
	}

	@PostMapping("/address")
	public void addEmployeeAddress(@RequestBody EmployeeDto empDto) {

		service.addEmployeeAddress(employeeMapper.employeeDtoToEmployee(empDto));

	}

	@PutMapping("/address")
	public void updateEmployeeAddress(@RequestBody AddressDto addressDto) {

		service.updateEmployeeAddress(mapstructMapper.addressDtoToAdress(addressDto));

	}

}
