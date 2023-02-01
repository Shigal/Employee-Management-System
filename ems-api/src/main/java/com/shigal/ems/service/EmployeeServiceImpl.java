package com.shigal.ems.service;/*
 *
 * @author Lawshiga
 *
 */

import com.fasterxml.jackson.databind.ObjectMapper;
import com.shigal.ems.entity.EmployeeEntity;
import com.shigal.ems.exception.BusinessException;
import com.shigal.ems.model.Employee;
import com.shigal.ems.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    @Override
    public Employee createEmployee(Employee employee) {
        EmployeeEntity employeeEntity = new EmployeeEntity();
        BeanUtils.copyProperties(employee, employeeEntity);

        if(employee.getFirstName().isEmpty() || employee.getFirstName().length() == 0) {
            throw new BusinessException("601", "Please send proper Firstname, It is blank");
        }
        try {
            employeeRepository.save(employeeEntity);
        }
        catch (IllegalArgumentException e) {
            throw new BusinessException("602", "This employee is null " + e.getMessage());
        }
        catch (Exception e) {
            throw new BusinessException("603", "Something went wrong in service layer while saving the employee" + e.getMessage());
        }
        return employee;
    }

    @Override
    public List<Employee> getAllEmployees() {
        List<EmployeeEntity> employeeEntities = null;
        try {
            employeeEntities = employeeRepository.findAll();
        }
        catch (Exception e) {
            throw new BusinessException("605", "Something went wrong in service layer while fetching all employee records " + e.getMessage());
        }
        if(employeeEntities.isEmpty()) {
            throw new BusinessException("604", "There are no Employee records");
        }
        return employeeEntities.stream()
                .map(employee -> new Employee(employee.getId(), employee.getFirstName(), employee.getLastName(), employee.getEmailId()))
                .collect(Collectors.toList());
    }

    @Override
    public boolean deleteEmployee(Long id) {
        try {
            EmployeeEntity employeeEntity = employeeRepository.findById(id).get();
            employeeRepository.delete(employeeEntity);
            return true;
        }
        catch (IllegalArgumentException e) {
            throw new BusinessException("608", "given employee id is null, try with another id " + e.getMessage());
        }
    }

    @Override
    public Employee getEmployeeById(Long id) {
        try {
            EmployeeEntity employeeEntity = employeeRepository.findById(id).get();
            Employee employee = new Employee();
            BeanUtils.copyProperties(employeeEntity, employee);
            return employee;
        }
        catch (IllegalArgumentException e) {
            throw new BusinessException("606", "given employee id is null, try with another id " + e.getMessage());
        }
        catch (NoSuchElementException e) {
            throw new BusinessException("607", "given employee id does not exist " + e.getMessage());
        }
    }

    @Override
    public Employee updateEmployee(Long id, Employee employee) {
        EmployeeEntity employeeEntity = employeeRepository.findById(id).get();
        employeeEntity.setFirstName(employee.getFirstName());
        employeeEntity.setLastName(employee.getLastName());
        employeeEntity.setEmailId(employee.getEmailId());
        employeeRepository.save(employeeEntity);
        return employee;
    }


}
