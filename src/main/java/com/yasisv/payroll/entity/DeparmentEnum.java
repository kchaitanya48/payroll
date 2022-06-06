package com.yasisv.payroll.entity;

public enum DeparmentEnum {
	
	MANAGER(1),
	DEVELOPER(2),
	TESTER(3),
	DELIVERYMANAGER(4);
	
	private Integer value;

	private DeparmentEnum(int value) {
		this.value = value;
	}

	

}
