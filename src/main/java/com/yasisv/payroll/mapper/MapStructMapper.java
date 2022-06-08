package com.yasisv.payroll.mapper;

import org.mapstruct.Mapper;

import com.yasisv.payroll.entity.Address;
import com.yasisv.payroll.entity.Department;
import com.yasisv.payroll.entity.Employee;
import com.yasisv.payroll.model.AddressDto;
import com.yasisv.payroll.model.DepartmentDto;
import com.yasisv.payroll.model.EmployeeDto;
@Mapper(
        componentModel = "spring"
)
public interface MapStructMapper {

	
	
	AddressDto addressToAddressDto(Address Address);
	Address addressDtoToAdress(AddressDto addressDto);
	
	
	  DepartmentDto departmentToDepartmentDto(Department department); Department
	  departmentDtoToDepartment(DepartmentDto departmentDto);
	 
	
	
	
}
