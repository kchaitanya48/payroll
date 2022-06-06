package com.yasisv.payroll.service;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yasisv.payroll.entity.Address;
import com.yasisv.payroll.entity.Employee;
import com.yasisv.payroll.repository.AddressRepository;
import com.yasisv.payroll.repository.DepartmentRepository;
import com.yasisv.payroll.repository.EmployeeRepository;


@Service

public class EmployeeService {

	@Autowired
	EmployeeRepository empRepository;
	@Autowired
	AddressRepository addressRepository;
	@Autowired
	DepartmentRepository departmentRepository;


	@Transactional
	public void saveEmployee(Employee employee) {
		//departmentRepository.findById(employee.getDepartment().getDeptName().valueOf(null));
		empRepository.saveAndFlush(employee);
	}
	
	@Transactional
	public void updateEmployee(Employee employee) {
		Optional<Employee> ee1=empRepository.findById(employee.getEmpId());
		Employee emp=ee1.get();
		emp.setEmpName(employee.getEmpName());
	}
	
	@Transactional
	public void addEmployeeAddress(Employee employee) {
		Optional<Employee> ee1=empRepository.findById(employee.getEmpId());
		Employee emp=ee1.get();
		emp.getEmpAddress().addAll(employee.getEmpAddress());
	}
	
	@Transactional
	public void updateEmployeeAddress(Address address) {
		Optional<Address> aa=addressRepository.findById(address.getAddrId());
		Address aa1=aa.get();
		aa1.setAddress1(address.getAddress1());
		aa1.setAddress2(address.getAddress2());
		aa1.setAddrType(address.getAddrType());
		aa1.setCity(address.getCity());
		aa1.setCountry(address.getCountry());
		aa1.setPincode(address.getPincode());
		aa1.setState(address.getState());
	}


}
