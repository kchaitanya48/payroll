package com.yasisv.payroll.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.yasisv.payroll.entity.Address;
import com.yasisv.payroll.entity.Department;
import com.yasisv.payroll.entity.Employee;
import com.yasisv.payroll.entity.Employeesalary;
import com.yasisv.payroll.model.AddressDto;
import com.yasisv.payroll.model.DepartmentDto;
import com.yasisv.payroll.model.EmployeeDto;
import com.yasisv.payroll.model.EmployeeSalaryDto;

@Mapper(componentModel = "spring")
public interface MapStructMapper {

	AddressDto addressToAddressDto(Address Address);

	Address addressDtoToAdress(AddressDto addressDto);

	DepartmentDto departmentToDepartmentDto(Department department);

	Department departmentDtoToDepartment(DepartmentDto departmentDto);

	//@Mapping(source = "emp.empId",target = "empId")
	EmployeeSalaryDto employeeSalaryToEmployeeSalaryDto(Employeesalary employeesalary);
	//@Mapping(source = "empId",target = "emp.empId")
	Employeesalary EmployeeSalaryDtoToEmployeeSalary(EmployeeSalaryDto employeeSalaryDto);

}
