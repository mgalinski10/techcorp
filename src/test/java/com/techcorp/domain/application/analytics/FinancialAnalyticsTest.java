package com.techcorp.domain.application.analytics;

import java.util.List;
import java.util.Optional;

import com.techcorp.domain.entity.Employee;
import com.techcorp.domain.JobPosition;
import com.techcorp.application.analytics.FinancialAnalytics;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class FinancialAnalyticsTest {
    private FinancialAnalytics financialAnalytics;

    @BeforeEach
    void setUp() {
        Employee e1 = new Employee("Jan", "Kowalski", "jan.kowalski@gmail.com", "TechCorp", JobPosition.CEO);
        Employee e2 = new Employee("Anna", "Nowak", "anna.nowak@gmail.com", "TechCorp", JobPosition.DEVELOPER);
        List<Employee> employees = List.of(e1, e2);

        financialAnalytics = new FinancialAnalytics(employees);
    }

    @Test
    void shouldCalculateAvarageSalary() {
        double result = financialAnalytics.calculateAvarageSalary();

        assertEquals(16500, result);
    }

    @Test
    void shouldReturnHighestPaidEmployee() {
        Optional<Employee> result = financialAnalytics.findHighestPaidEmployee();

        assertEquals("jan.kowalski@gmail.com", result.get().getEmail());
    }
}
