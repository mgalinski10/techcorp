package com.techcorp.application.analytics;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import com.techcorp.domain.entity.Employee;


public class FinancialAnalytics {
    private final List<Employee> employees;

    public FinancialAnalytics(List<Employee> employees) {
        this.employees = employees;
    }

    public double calculateAvarageSalary() {
        return employees.stream().mapToDouble(Employee::getSalary).average().orElse(0.0);
    }

    public Optional<Employee> findHighestPaidEmployee() {
        return employees.stream().max(Comparator.comparingDouble(Employee::getSalary));
    }
}
