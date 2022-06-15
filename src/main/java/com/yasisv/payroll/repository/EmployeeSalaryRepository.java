package com.yasisv.payroll.repository;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.yasisv.payroll.entity.Employeesalary;

@Repository
public interface EmployeeSalaryRepository extends JpaRepository<Employeesalary, Integer>{
	

	@Query(value ="SELECT e.emp_id as  employeeId,e.emp_name as employeeName,d.dept_name as departmentName,es.pf as pf ,es.salary as salary "
			+ "FROM  employeesalary es , Employee e,Department d  where e.emp_id=es.emp_id and d.dept_id=e.dept_id and  e.emp_id = :empId",nativeQuery =true)
	List<Object[]> findEmployeeAndEmloyeeSalaryByEmpId(@Param("empId") Integer empId);

}
