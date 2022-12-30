package com.shigal.ems.service;/*
 *
 * @author Lawshiga
 *
 */

import com.shigal.ems.model.Employee;

import java.util.List;

public interface EmployeeService {

    Employee createEmployee(Employee employee);

    List<Employee> getAllEmployees();

}
