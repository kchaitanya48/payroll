package com.yasisv.payroll.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.springframework.beans.factory.annotation.Autowired;

import com.yasisv.payroll.entity.Department;
import com.yasisv.payroll.entity.Employee;
import com.yasisv.payroll.model.EmployeeDto;
import com.yasisv.payroll.service.DepartmentService;

@Mapper(componentModel = "spring")
public abstract class EmployeeMapper {

	@Autowired
	DepartmentService departmentService;

	@Mapping(source = "deptName", target = "department", qualifiedByName = "deptNameToDepartment")
	public abstract Employee employeeDtoToEmployee(EmployeeDto employeeDto);
	@Mapping(source = "department.deptName",target = "deptName")
    public abstract EmployeeDto employeeToEmployeeDto(Employee employee);

	@Named("deptNameToDepartment")
	public Department deptNameToDepartment(String deptName) {
		return departmentService.getDeptId(deptName);
	}

}
