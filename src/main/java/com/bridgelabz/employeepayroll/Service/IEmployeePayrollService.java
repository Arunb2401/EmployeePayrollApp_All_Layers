package com.bridgelabz.employeepayroll.Service;

import java.util.List;

import com.bridgelabz.employeepayroll.DTO.EmployeePayrollDTO;
import com.bridgelabz.employeepayroll.Model.EmployeepayrollData;

public interface IEmployeePayrollService {

    List<EmployeepayrollData> getEmployeePayrollData();
    
    EmployeepayrollData getEmployeePayrollDataById(int empId);
    
    // EmployeepayrollData getEmployeesByDepartment(String department);

    EmployeepayrollData createEmployeepayrollData(EmployeePayrollDTO employeePayrollDTO);
    
    EmployeepayrollData updateEmployeePayrollData(EmployeePayrollDTO employeePayrollDTO);
    
    void deleteEmployeePayrollData(int empId);
}
