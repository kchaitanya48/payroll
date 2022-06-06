package com.yasisv.payroll;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@EnableAutoConfiguration
//@Configuration
//@ComponentScan(basePackages="com.yasisv.payroll")
//@EnableJpaRepositories("com.spring.app.repository")
public class PayrollApplication {

	public static void main(String[] args) {
		SpringApplication.run(PayrollApplication.class, args);
	}

}
