package com.bridgelabz.employeepayroll.DTO;

// import java.security.Timestamp;
// import java.time.LocalDate;
import java.util.List;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
// import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Pattern;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.ToString;

public @ToString class EmployeePayrollDTO {
    
    @Pattern(regexp = "[A-Z]{1}[a-zA-Z\\s]{2,}$",
             message = "Employee name is InValid")
    public  String name;

    @Min(value = 5000, message = "Minimum salary should be more than 5000")
    public  long salary;

    @Pattern(regexp = "male|female", message = "Gender needs to be Male or Female")
    public  String gender;
    
    // @JsonSerialize(as = Timestamp.class)
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern = "dd-MMM-yyyy")    
    @NotNull (message = "Start Date should not be Empty!")
    @PastOrPresent (message = "Start Date should be past or today's date")
    public String startDate;
    
    
    @NotBlank (message = "Note should be written.")
    public String note;
    
    
    @NotBlank(message = "ProfilePic can't be Empty")
    public String profilePic;

    @NotNull(message = "Get the Technology ")
    public List<String> department; 

}
