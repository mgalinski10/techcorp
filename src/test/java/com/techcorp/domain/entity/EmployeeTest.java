package com.techcorp.domain.entity;

import com.techcorp.domain.JobPosition;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class EmployeeTest {
    @Test
    void shouldCreateEmployee() {
        Employee employee = new Employee("Jan", "Kowalski", "jan.kowalski@gmail.com", "TechCorp", JobPosition.CEO);

        assertEquals("Jan Kowalski", employee.getFullName());
        assertEquals("jan.kowalski@gmail.com", employee.getEmail());
        assertEquals("Chief Executive Officer", employee.getPositionName());
        assertEquals(1, employee.getLevel());
        assertEquals(25000, employee.getSalary());
    }

    @Test
    void shouldReturnTrue_WhenCompareEmployees() {
        Employee ceo = new Employee("Jan", "Kowalski", "jan.kowalski@gmail.com", "TechCorp", JobPosition.CEO);
        Employee sameCeo = new Employee("Jan", "Kowalski", "jan.kowalski@gmail.com", "TechCorp", JobPosition.CEO);

        boolean status = ceo.equals(sameCeo);

        assertTrue(status);
    }

    @Test
    void shouldReturnFalse_WhenCompareEmployees() {
        Employee ceo = new Employee("Jan", "Kowalski", "jan.kowalski@gmail.com", "TechCorp", JobPosition.CEO);
        Employee diffrentCeo = new Employee("Adam", "Nowak", "adam.nowak@gmail.com", "TechCorp", JobPosition.CEO);

        boolean status = ceo.equals(diffrentCeo);

        assertFalse(status);
    }
}
