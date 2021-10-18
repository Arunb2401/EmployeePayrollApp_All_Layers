package com.bridgelabz.employeepayroll.Controller;

import java.util.List;

import javax.validation.Valid;

import com.bridgelabz.employeepayroll.DTO.EmployeePayrollDTO;
import com.bridgelabz.employeepayroll.DTO.ResponseDTO;
import com.bridgelabz.employeepayroll.Model.EmployeepayrollData;
import com.bridgelabz.employeepayroll.Service.IEmployeePayrollService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/employeepayrollservice")
@Slf4j
public class EmployeePayrollController {

    @Autowired
    private IEmployeePayrollService employeePayrollService;

    @RequestMapping(value = { "", "/", "/get" })
    public ResponseEntity<ResponseDTO> getEmployeePayrollData() {
        List<EmployeepayrollData> employeeDataList = null;
        employeeDataList = employeePayrollService.getEmployeePayrollData();
        ResponseDTO responseDTO = new ResponseDTO("GET call is Successful", employeeDataList);
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }

    /**
     * 
     * @param empId
     * @return
     */
    @GetMapping("/get/{empId}")
    public ResponseEntity<ResponseDTO> getEmployeePayrollData(@PathVariable("empId") int empId) {
        EmployeepayrollData employeeData = null;
        employeeData = employeePayrollService.getEmployeePayrollDataById(empId);
        ResponseDTO responseDTO = new ResponseDTO("GET call for ID is successfull for ID: ", employeeData);
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }


    // @GetMapping("/department/{department}")
    // public ResponseEntity<ResponseDTO> getEmployeePayrollData(@PathVariable("department") String department) {
    //     List<EmployeepayrollData> employeeDataList = null;
    //     employeeDataList = employeePayrollService.getEmployeesByDepartment(department);
    //     ResponseDTO responseDTO = new ResponseDTO("GET call for Department is successfull: ", employeeDataList);
    //     return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    // }
    /**
     * 
     * @param employeepayrollDTO
     * @return
     */

    @PostMapping("/create")
    public ResponseEntity<ResponseDTO> addEmployeePayrollData(
            @Valid @RequestBody EmployeePayrollDTO employeepayrollDTO) {
        log.debug("Employee DTO:" + employeepayrollDTO.toString());
        EmployeepayrollData employeeData = null;
        employeeData = employeePayrollService.createEmployeepayrollData(employeepayrollDTO);
        ResponseDTO responseDTO = new ResponseDTO("Created Employee Payroll Data Successfull !!", employeeData);
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }

    /**
     * 
     * @param employeePayrollDTO
     * @return
     */
    @PutMapping("/update/{empId}")
    public ResponseEntity<ResponseDTO> updateEmployeePayrollData(@PathVariable("empId") int empId,
            @Valid @RequestBody EmployeePayrollDTO employeePayrollDTO) {
        log.debug("Employee DTO:" + employeePayrollDTO.toString());
        EmployeepayrollData employeeData = null;
        employeeData = employeePayrollService.updateEmployeePayrollData(employeePayrollDTO);
        ResponseDTO responseDTO = new ResponseDTO("Updated Employee Payroll Data Successfully!!", employeeData);
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }

    /**
     * 
     * @param empId
     * @return
     */
    @DeleteMapping("/delete/{empId}")
    public ResponseEntity<ResponseDTO> deleteEmployeePayrollData(@PathVariable("empId") int empId) {
        employeePayrollService.deleteEmployeePayrollData(empId);
        ResponseDTO responseDTO = new ResponseDTO("DELETED Successfully !!", "Deleted ID: " + empId);
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }

}
