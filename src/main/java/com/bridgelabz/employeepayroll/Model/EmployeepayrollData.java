package com.bridgelabz.employeepayroll.Model;

import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

import com.bridgelabz.employeepayroll.DTO.EmployeePayrollDTO;
import lombok.Data;

@Entity
@Table(name = "employee_payroll")
public @Data class EmployeepayrollData {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "Emp_id")
    private int empId;

    @Column(name = "Name")
    private String name;
    
    private long salary;
    private String gender;
    private String startDate;
    private String note;
    private String profilePic;

    @ElementCollection
    @CollectionTable(name = "employee_department", joinColumns = @JoinColumn(name = "id"))
    @Column(name = "Department")
    private List<String> department;

    public EmployeepayrollData() {}

    public EmployeepayrollData(EmployeePayrollDTO employeePayrollDTO) {
        this.updateEmployeePayrollData(employeePayrollDTO);
    }  

    public void updateEmployeePayrollData(EmployeePayrollDTO employeePayrollDTO) {
        this.name = employeePayrollDTO.name;
        this.salary = employeePayrollDTO.salary;
        this.gender = employeePayrollDTO.gender;
        this.note = employeePayrollDTO.note;
        this.startDate = employeePayrollDTO.startDate;
        this.profilePic = employeePayrollDTO.profilePic;
        this.department=employeePayrollDTO.department;
    }
}