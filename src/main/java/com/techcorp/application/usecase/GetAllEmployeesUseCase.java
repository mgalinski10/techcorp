package com.techcorp.application.usecase;

import com.techcorp.domain.entity.Employee;
import com.techcorp.domain.repository.EmployeeRepository;

import java.util.List;

public class GetAllEmployeesUseCase {
    private final EmployeeRepository employeeRepository;

    public GetAllEmployeesUseCase(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public List<Employee> execute() {
        return employeeRepository.getAllEmployees();
    }
}
