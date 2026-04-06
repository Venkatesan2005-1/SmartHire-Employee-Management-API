 package com.venkatesan.smarthire.controller;

import com.venkatesan.smarthire.entity.Employee;
import com.venkatesan.smarthire.service.EmployeeService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
@RequiredArgsConstructor
public class EmployeeController{
    private final EmployeeService employeeService;
    @GetMapping
    public ResponseEntity<List<Employee>> getAllEmployees(){
        return ResponseEntity.ok(employeeService.getAllEmployees());
    }
    @GetMapping("/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id){
        return ResponseEntity.ok(employeeService.getEmployeeById(id));
    }

    @PostMapping
    public ResponseEntity<Employee> createEmployee(@Valid @RequestBody Employee employee){
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(employeeService.createEmployee(employee));
    }
    @PutMapping("/{id}")
    public ResponseEntity<Employee> updateEmployee(
            @PathVariable Long id,
            @Valid @RequestBody Employee employeeDetails){
        return ResponseEntity.ok(employeeService.updateEmployee(id,employeeDetails));
    }
    @DeleteMapping("/{id}")
        public ResponseEntity<String> deleteEmployee(@PathVariable Long id){
            employeeService.deleteEmployee(id);
            return ResponseEntity.ok("Employee deleted successfully!");
        }
}
