package com.bridgelabz.employeepayroll.Service;

import java.util.List;

import com.bridgelabz.employeepayroll.DTO.EmployeePayrollDTO;
import com.bridgelabz.employeepayroll.Exception.CustomEmployeePayrollException;
import com.bridgelabz.employeepayroll.Model.EmployeepayrollData;
import com.bridgelabz.employeepayroll.Repository.EmployeePayrollRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class EmployeePayrollService implements IEmployeePayrollService {

    @Autowired
    private EmployeePayrollRepository employeeRepository;

    public List<EmployeepayrollData> getEmployeePayrollData() {
        return employeeRepository.findAll();
    }
    
    public EmployeepayrollData getEmployeePayrollDataById(int empId) {
        return employeeRepository
        .findById(empId)
        .orElseThrow(() -> new CustomEmployeePayrollException
                                ("Employee with EmployeeID" + empId + "does not Exists.....!!"));
    }

    public EmployeepayrollData createEmployeepayrollData(EmployeePayrollDTO employeePayrollDTO) {
        EmployeepayrollData employeeData = null;
        employeeData = new EmployeepayrollData(employeePayrollDTO);
        log.debug("Employee Data: " + employeeData.toString());
        return employeeRepository.save(employeeData);
    }

    public EmployeepayrollData updateEmployeePayrollData(int empId, EmployeePayrollDTO employeePayrollDTO) {
        EmployeepayrollData employeeData = this.getEmployeePayrollDataById(empId);
        employeeData.updateEmployeePayrollData(employeePayrollDTO);
        return employeeRepository.save(employeeData);
    }

    @Override
    public EmployeepayrollData updateEmployeePayrollData(EmployeePayrollDTO employeePayrollDTO) {
        return null;
    }
    public void deleteEmployeePayrollData(int empId) {
        EmployeepayrollData employeeData = this.getEmployeePayrollDataById(empId);
        employeeRepository.delete(employeeData);
    }

    
   
}