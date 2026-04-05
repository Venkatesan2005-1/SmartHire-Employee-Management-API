package com.venkatesan.smarthire.service;

import com.venkatesan.smarthire.entity.Employee;
import com.venkatesan.smarthire.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeService{
    private final EmployeeRepository employeeRepository;
    public List<Employee> getAllEmployees(){
        return employeeRepository.findAll();
    }
    public Employee getEmployeeById(Long id){
        return employeeRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Employee not found with id: "+id));
    }
    public Employee createEmployee(Employee employee){
        return employeeRepository.save(employee);
    }
    public Employee updateEmployee(Long id,Employee employeeDetails){
        Employee employee=getEmployeeById(id);
        employee.setName(employeeDetails.getName());
        employee.setEmail(employeeDetails.getEmail());
        employee.setDepartment(employeeDetails.getDepartment());
        employee.setSalary(employeeDetails.getSalary());
        employee.setJoiningDate(employeeDetails.getJoiningDate());
        return employeeRepository.save(employee);
    }
    public void deleteEmployee(Long id){
        Employee employee=getEmployeeById(id);
        employeeRepository.deleteById(employee.getId());
    }
}
