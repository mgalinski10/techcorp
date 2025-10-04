package com.techcorp.application.usecase;

import com.techcorp.application.dto.EmployeeDTO;

import com.techcorp.domain.entity.Employee;
import com.techcorp.domain.exception.EmployeeWithThatEmailExistsException;
import com.techcorp.domain.repository.EmployeeRepository;

public class CreateEmployeeUseCase {
    private final EmployeeRepository employeeRepository;

    public CreateEmployeeUseCase(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public void execute(EmployeeDTO employeeDTO) {
        employeeRepository.findEmployeeByEmail(employeeDTO.email())
                .ifPresent(e -> {
                    throw new EmployeeWithThatEmailExistsException(
                            "Employee with that email already exists."
                    );
                });

        Employee newEmployee = new Employee(employeeDTO.firstName(), employeeDTO.lastName(), employeeDTO.email(), employeeDTO.position());

        employeeRepository.save(newEmployee);
    }
}
