package com.yasisv.payroll.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.yasisv.payroll.entity.Department;
import com.yasisv.payroll.mapper.MapStructMapper;
import com.yasisv.payroll.model.DepartmentDto;
import com.yasisv.payroll.service.DepartmentService;

@RestController
public class DepartmentController {

	@Autowired
	DepartmentService departmentService;
	
	@Autowired
	private MapStructMapper mapstructMapper;
	
	@GetMapping(value="/addDeparment", consumes =MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public void saveDepartment(@RequestBody DepartmentDto departmentDto) {
		departmentService.addDepartment(mapstructMapper.departmentDtoToDepartment(departmentDto));
	}
	
}
