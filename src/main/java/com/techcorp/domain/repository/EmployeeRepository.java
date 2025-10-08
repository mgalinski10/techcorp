package com.techcorp.domain.repository;

import java.util.List;
import java.util.Optional;

import com.techcorp.domain.entity.Employee;


public interface EmployeeRepository {
    Optional<Employee> findEmployeeByEmail(String email);

    List<Employee> getAllEmployees();

    void save(Employee employee);

    void delete(Employee employee);
}
