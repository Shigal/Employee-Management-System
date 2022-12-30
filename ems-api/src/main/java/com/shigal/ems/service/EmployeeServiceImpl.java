package com.shigal.ems.service;/*
 *
 * @author Lawshiga
 *
 */

import com.fasterxml.jackson.databind.ObjectMapper;
import com.shigal.ems.entity.EmployeeEntity;
import com.shigal.ems.model.Employee;
import com.shigal.ems.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    @Override
    public Employee createEmployee(Employee employee) {
        EmployeeEntity employeeEntity = new EmployeeEntity();
        BeanUtils.copyProperties(employee, employeeEntity);
        employeeRepository.save(employeeEntity);
        return employee;
    }

    @Override
    public List<Employee> getAllEmployees() {
        List<EmployeeEntity> employeeEntities = employeeRepository.findAll();
        return employeeEntities.stream()
                .map(employee -> new Employee(employee.getId(), employee.getFirstName(), employee.getLastName(), employee.getEmailId()))
                .collect(Collectors.toList());
    }
}
