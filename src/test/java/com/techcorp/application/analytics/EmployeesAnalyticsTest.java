package com.techcorp.application.analytics;

import java.util.List;
import java.util.Map;
import java.util.Set;

import com.techcorp.domain.entity.Employee;
import com.techcorp.domain.entity.JobPosition;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class EmployeesAnalyticsTest {
    private EmployeesAnalytics employeesAnalytics;

    @BeforeEach
    void setUp() {
        Employee e1 = new Employee("Jan", "Kowalski", "jan.kowalski@gmail.com", "TechCorp", JobPosition.CEO);
        Employee e2 = new Employee("Anna", "Nowak", "anna.nowak@gmail.com", "TechCorp", JobPosition.DEVELOPER);
        Employee e3 = new Employee("Piotr", "Zieliński", "piotr.zielinski@gmail.com", "TechCorp", JobPosition.MANAGER);
        Employee e4 = new Employee("Ola", "Kaczmarek", "ola.kaczmarek@gmail.com", "SoftSolutions", JobPosition.DEVELOPER);
        Employee e5 = new Employee("Tomasz", "Wiśniewski", "tomasz.wisniewski@gmail.com", "SoftSolutions", JobPosition.VP);
        List<Employee> employees = List.of(e1, e2, e3, e4, e5);

        employeesAnalytics = new EmployeesAnalytics(employees);
    }

    @Test
    void shouldListEmployeesByCompany() {
        List<Employee> result = employeesAnalytics.getEmployeesByCompany("TechCorp");

        List<Employee> expected = List.of(
                new Employee("Jan", "Kowalski", "jan.kowalski@gmail.com", "TechCorp", JobPosition.CEO),
                new Employee("Anna", "Nowak", "anna.nowak@gmail.com", "TechCorp", JobPosition.DEVELOPER),
                new Employee("Piotr", "Zieliński", "piotr.zielinski@gmail.com", "TechCorp", JobPosition.MANAGER)
        );

        assertEquals(result, expected);
    }

    @Test
    void shouldSortEmployeesByLastName() {
        List<Employee> result = employeesAnalytics.getEmployeesSortedByLastName();

        List<Employee> expected = List.of(
                new Employee("Ola", "Kaczmarek", "ola.kaczmarek@gmail.com", "SoftSolutions", JobPosition.DEVELOPER),
                new Employee("Jan", "Kowalski", "jan.kowalski@gmail.com", "TechCorp", JobPosition.CEO),
                new Employee("Anna", "Nowak", "anna.nowak@gmail.com", "TechCorp", JobPosition.DEVELOPER),
                new Employee("Tomasz", "Wiśniewski", "tomasz.wisniewski@gmail.com", "SoftSolutions", JobPosition.VP),
                new Employee("Piotr", "Zieliński", "piotr.zielinski@gmail.com", "TechCorp", JobPosition.MANAGER)
        );

        assertEquals(result, expected);
    }

    @Test
    void shouldGroupEmployeesByPosition() {
        // TODO: test only checks if keys and list size are correct, but in general method works fine. Mby add some sorting in the future to have consistency results every time

        Map<String, List<Employee>> result = employeesAnalytics.groupEmployeesByPosition();

        assertEquals(Set.of("Vice President", "Developer", "Chief Executive Officer", "Manager"), result.keySet());
        assertEquals(1, result.get("Chief Executive Officer").size());
        assertEquals(2, result.get("Developer").size());
        assertEquals(1, result.get("Manager").size());
        assertEquals(1, result.get("Vice President").size());
    }

    @Test
    void shouldCountEmployeesForEachPosition() {
        Map<String, Long> result = employeesAnalytics.getEmployeesNumberForEachPosition();

        assertEquals(1, result.get("Chief Executive Officer"));
        assertEquals(2, result.get("Developer"));
        assertEquals(1, result.get("Manager"));
        assertEquals(1, result.get("Vice President"));
    }


}
