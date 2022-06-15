package com.yasisv.payroll.model;

public class EmployeePayroll {

	private Integer employeeId;
	private String employeeName;
	private String departmentName;
	private Double grossSalary;
	private Double netSalary;
	private Integer pf;
	private double tax;
	
	
	
	
	public EmployeePayroll(Builder builder) {
		this.employeeId=builder.employeeId;
		this.employeeName=builder.employeeName;
		this.departmentName=builder.departmentName;
		this.grossSalary=builder.grossSalary;
		this.netSalary=builder.netSalary;
		this.pf=builder.pf;
		this.tax=builder.tax;
	}
	
	
	




	public Integer getEmployeeId() {
		return employeeId;
	}







	public String getEmployeeName() {
		return employeeName;
	}







	public String getDepartmentName() {
		return departmentName;
	}







	public Double getGrossSalary() {
		return grossSalary;
	}







	public Double getNetSalary() {
		return netSalary;
	}







	public Integer getPf() {
		return pf;
	}







	public double getTax() {
		return tax;
	}







	public static class Builder{
		private Integer employeeId;
		private String employeeName;
		private String departmentName;
		private String salary;
		private Double grossSalary;
		private Double netSalary;
		private Integer pf;
		private double tax;
		
		
		public Builder setEmployeeId(Integer employeeId) {
			this.employeeId = employeeId;
			return this;
			
		}
		public Builder setEmployeeName(String employeeName) {
			this.employeeName = employeeName;
			return this;
		}
		public Builder setDepartmentName(String departmentName) {
			this.departmentName = departmentName;
			return this;
		}
		public Builder setGrossSalary(Double grossSalary) {
			this.grossSalary = grossSalary;
			return this;
		}
		public Builder setNetSalary(Double netSalary) {
			this.netSalary = netSalary;
			return this;
		}
		public Builder setPf(Integer pf) {
			this.pf = pf;
			return this;
		}
		public Builder setTax(double tax) {
			this.tax = tax;
			return this;
		}
		
		
		public EmployeePayroll build() {
			return new EmployeePayroll(this);
		}
		
	}

}
