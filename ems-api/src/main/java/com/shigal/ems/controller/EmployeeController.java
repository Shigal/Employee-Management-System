package com.shigal.ems.controller;/*
 *
 * @author Lawshiga
 *
 */

import com.shigal.ems.exception.BusinessException;
import com.shigal.ems.exception.ControllerException;
import com.shigal.ems.model.Employee;
import com.shigal.ems.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1/")
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeService employeeService;

    @PostMapping("/employees")
    public ResponseEntity<?> createEmployee(@RequestBody Employee employee) {
        try {
            return new ResponseEntity<Employee>(employeeService.createEmployee(employee), HttpStatus.CREATED);
        }
        catch (BusinessException e) {
            ControllerException ce = new ControllerException(e.getErrorCode(), e.getErrorMessage());
            return new ResponseEntity<ControllerException>(ce, HttpStatus.BAD_REQUEST); // check errorCode(601-607), provide correct HttpStatus
        }
        catch (Exception e) {
            ControllerException ce = new ControllerException("608", "Something went wrong in controller");
            return new ResponseEntity<ControllerException>(ce, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/employees")
    public ResponseEntity<?> getAllEmployees(){
        try {
            return new ResponseEntity<List<Employee>>(employeeService.getAllEmployees(), HttpStatus.OK);
        }
        catch (BusinessException e) {
            ControllerException ce = new ControllerException(e.getErrorCode(), e.getErrorMessage());
            return new ResponseEntity<ControllerException>(ce, HttpStatus.BAD_REQUEST); // check errorCode(601-607), provide correct HttpStatus
        }
        catch (Exception e) {
            ControllerException ce = new ControllerException("609", "Something went wrong in controller");
            return new ResponseEntity<ControllerException>(ce, HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/employees/{id}")
    public ResponseEntity<?> deleteEmployee(@PathVariable Long id){
        boolean deleted = false;
        Map<String, Boolean> response = new HashMap<>();
        try {
            deleted = employeeService.deleteEmployee(id);
            response.put("deleted", deleted);
            return ResponseEntity.ok(response);
        }
        catch (BusinessException e) {
            ControllerException ce = new ControllerException(e.getErrorCode(), e.getErrorMessage());
            return new ResponseEntity<ControllerException>(ce, HttpStatus.BAD_REQUEST);
        }
        catch (Exception e) {
            ControllerException ce = new ControllerException("610", "Something went wrong in controller");
            return new ResponseEntity<ControllerException>(ce, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/employees/{id}")
    public ResponseEntity<?> getEmployeeById(@PathVariable Long id){
        try {
            Employee employee = employeeService.getEmployeeById(id);
            return ResponseEntity.ok(employee);
        }
        catch (BusinessException e) {
            ControllerException ce = new ControllerException(e.getErrorCode(), e.getErrorMessage());
            return new ResponseEntity<ControllerException>(ce, HttpStatus.BAD_REQUEST);
        }
        catch (Exception e) {
            ControllerException ce = new ControllerException("611", "Something went wrong in controller");
            return new ResponseEntity<ControllerException>(ce, HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/employees/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable Long id,
                                                   @RequestBody Employee employee) {
        employee = employeeService.updateEmployee(id, employee);
        return ResponseEntity.ok(employee);

    }}
