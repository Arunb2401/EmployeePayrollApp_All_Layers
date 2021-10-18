package com.bridgelabz.employeepayroll.Repository;

import com.bridgelabz.employeepayroll.Model.EmployeepayrollData;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeePayrollRepository  extends JpaRepository<EmployeepayrollData, Integer>{
//   @Query(value = "select * from employee_payroll, employee_department where emp_id = id and department = :department")
//   List<EmployeepayrollData> findEmployeesByDeparment(String department);  

} 
