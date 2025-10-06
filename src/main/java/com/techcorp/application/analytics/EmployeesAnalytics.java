package com.techcorp.application.analytics;

import com.techcorp.domain.entity.Employee;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class EmployeesAnalytics {
    private final List<Employee> employees;

    public EmployeesAnalytics(List<Employee> employees) {
        this.employees = employees;
    }

    public List<Employee> getEmployeesByCompany(String company) {
        return employees.stream().filter(e -> e.getCompany().equals(company)).toList();
    }

    public List<Employee> getEmployeesSortedByLastName() {
        return employees.stream().sorted(Comparator.comparing(Employee::getLastName)).toList();
    }

    public Map<String, List<Employee>> groupEmployeesByPosition() {
        return employees.stream()
                .collect(Collectors.groupingBy(Employee::getPositionName));
    }

    public Map<String, Long> getEmployeesNumberForEachPosition() {
        return employees.stream()
                .collect(Collectors.groupingBy(Employee::getPositionName, Collectors.counting()));
    }
}
