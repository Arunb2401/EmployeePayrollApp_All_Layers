package com.bridgelabz.employeepayroll.Exception;

import java.util.List;
import java.util.stream.Collectors;

import com.bridgelabz.employeepayroll.DTO.ResponseDTO;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import lombok.extern.slf4j.Slf4j;

@ControllerAdvice
@Slf4j
public class EmployeePayrollExceptionHandler {
    
    private static final String message = "Exception while processing REST Request";
    
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<ResponseDTO> handleHttpMessageNotReadableException(
                        HttpMessageNotReadableException exception) {
        log.error("Invalid Date Format",  exception);
        ResponseDTO responseDTO = new ResponseDTO(message,"Should have Date in format dd MM yyyy");
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.BAD_REQUEST);        
    }            

    
    
    
    
    
    
    /**
     * 
     * @param exception
     * @return
     */

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ResponseDTO> handlerMethodArgumentNotValidException(
            MethodArgumentNotValidException exception) {
        List<ObjectError> errorList = exception.getBindingResult().getAllErrors();
        List<String> errMsg = errorList.stream().map(objErr -> objErr.getDefaultMessage()).collect(Collectors.toList());
        ResponseDTO responseDTO = new ResponseDTO("Exception while processing REST Request", errMsg);
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.BAD_REQUEST);
    }
 
    @ExceptionHandler(CustomEmployeePayrollException.class)
    public ResponseEntity<ResponseDTO> handleEmployeePayrollException(
                                        CustomEmployeePayrollException exception) {
    ResponseDTO responseDTO = new ResponseDTO("Exception while processing REST Request",
                                            exception.getMessage());
    return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.BAD_REQUEST);
    }
}

