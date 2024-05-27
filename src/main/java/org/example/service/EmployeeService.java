package org.example.service;

import lombok.AllArgsConstructor;
import org.example.dto.EmployeeDTO;
import org.example.model.Employee;
import org.example.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public Employee createEmployee(EmployeeDTO employeeDTO) {
        return employeeRepository.save(Employee.builder()
                .empName(employeeDTO.getEmpName())
                .empAge(employeeDTO.getEmpAge())
                .build());
    }

    public List<Employee> readAllEmployees() {
        return employeeRepository.findAll();
    }

    public Employee updateEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    public void deleteEmployee(Long id) {
        employeeRepository.deleteById(id);
    }
}
