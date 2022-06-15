package com.yasisv.payroll.service;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yasisv.payroll.entity.Employeesalary;
import com.yasisv.payroll.model.EmployeePayroll;
import com.yasisv.payroll.repository.EmployeeRepository;
import com.yasisv.payroll.repository.EmployeeSalaryRepository;
@Service
public class PayRollService {
	
	@Autowired
	EmployeeSalaryRepository employeeSalaryRepository;
	
	@Autowired
    EmployeeRepository employeeRepository;
	
	public Employeesalary save(Employeesalary employeesalary) {
		Employeesalary employeeSal=employeeSalaryRepository.save(employeesalary);
		return employeeSal;
	}
	
	public EmployeePayroll getEmployeeSalaryDetails(Integer empId) {
		List<Object[]> eroll=employeeSalaryRepository.findEmployeeAndEmloyeeSalaryByEmpId(empId);

		Object[] o=eroll.get(0);
		
		BigDecimal salary=(BigDecimal) o[4];
		double hra=salary.doubleValue()*0.15;
		double trans=salary.doubleValue()*0.25;
		double tax=salary.doubleValue()*0.30;
		double grossSalary=salary.doubleValue()+hra+trans;
		double netSalary=grossSalary-tax;
		
		BigDecimal employeeId=(BigDecimal) o[0];
		BigDecimal pf=(BigDecimal) o[3];
		
		
	
		return new EmployeePayroll.Builder().setEmployeeId(employeeId.intValue())
		.setEmployeeName(String.valueOf(o[1]))
		.setDepartmentName(String.valueOf(o[2]))
		.setPf(pf.intValue())
		.setGrossSalary(grossSalary)
		.setNetSalary(netSalary)
		.setTax(tax).build();
	}

}
