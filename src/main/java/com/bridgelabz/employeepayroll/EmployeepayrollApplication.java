package com.bridgelabz.employeepayroll;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@Slf4j
public class EmployeepayrollApplication {

	public static void main(String[] args) {
		System.out.println("Hello !!!! This is Employee Payroll Application >>>>>>>>>>>>");
		ApplicationContext context = SpringApplication.run(EmployeepayrollApplication.class, args);


		log.info("Employee Paroll App Started in {} Environment", context.getEnvironment().getProperty("environment"));
		log.info("Employee Payroll DB User is {}", context.getEnvironment().getProperty("spring.datasource.username"));
	}
}