package com.techcorp.domain.repository;

import com.techcorp.domain.entity.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeRepository {
    Optional<Employee> findEmployeeByEmail(String email);
    List<Employee> getAllEmployees();
    void save(Employee employee);
    void delete(Employee employee);
}
