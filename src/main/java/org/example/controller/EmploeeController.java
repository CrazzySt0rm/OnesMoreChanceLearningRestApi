package org.example.controller;

import lombok.AllArgsConstructor;
import org.example.dto.EmployeeDTO;
import org.example.model.Employee;
import org.example.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
public class EmploeeController {

    private final EmployeeService employeeService;

    @PostMapping("/employee")
    public ResponseEntity createEmployee(@RequestBody EmployeeDTO employeeDTO) {
        return new ResponseEntity<>(employeeService.createEmployee(employeeDTO), HttpStatus.OK);
    }

    @GetMapping("/employee")
    public ResponseEntity readAllEmployees() {
        return new ResponseEntity<>(employeeService.readAllEmployees(), HttpStatus.OK);
    }

    @PutMapping("/employee")
    public ResponseEntity updateEmployee(@RequestBody Employee employee) {
        return new ResponseEntity<>(employeeService.updateEmployee(employee), HttpStatus.OK);
    }
}
