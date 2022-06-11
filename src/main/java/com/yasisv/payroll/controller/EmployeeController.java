package com.yasisv.payroll.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.yasisv.payroll.entity.Address;
import com.yasisv.payroll.entity.AddressType;
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

	@GetMapping("/newEmployee")
	public String saveDetails(@RequestBody EmployeeDto empDto) {

		service.saveEmployee(employeeMapper.employeeDtoToEmployee(empDto));
		return "Hello world";
	}

	@GetMapping("/updateEmployee")
	public void updateEmployee() {

		EmployeeDto empDto = new EmployeeDto();

		empDto.setEmpId(1);
		empDto.setEmpName("krishna chaitanya");
		service.updateEmployee(employeeMapper.employeeDtoToEmployee(empDto));
	}

	@GetMapping("/addEmployeeAddress")
	public void addEmployeeAddress() {
		EmployeeDto empDto = new EmployeeDto();


		empDto.setEmpId(1);
		empDto.setEmpName("krishna chaitanya");

		AddressDto addressDto = new AddressDto();
		addressDto.setAddress1("hyderabad11");
		addressDto.setAddress2("address22");
		// address.setAddrId(2001);
		addressDto.setAddrType(AddressType.OFFICE);
		addressDto.setCity("Hyderabad");
		addressDto.setCountry("INDIA");
		addressDto.setPincode(500089);
		addressDto.setState("Telangana");
		List<AddressDto> addressList = new ArrayList<AddressDto>();
		addressList.add(addressDto);
		empDto.setEmpAddress(addressList);
		service.addEmployeeAddress(employeeMapper.employeeDtoToEmployee(empDto));

	}

	@GetMapping("/updateEmployeeAddress")
	public void updateEmployeeAddress() {


		AddressDto addressDto = new AddressDto();
		addressDto.setAddrId(22);
		addressDto.setAddress1("pragathinagar");
		addressDto.setAddress2("hyderabad");

		addressDto.setAddrType(AddressType.HOME);
		addressDto.setCity("Hyderabad");
		addressDto.setCountry("INDIA");
		addressDto.setPincode(500090);
		addressDto.setState("Telangana");

		service.updateEmployeeAddress(mapstructMapper.addressDtoToAdress(addressDto));

	}

}
