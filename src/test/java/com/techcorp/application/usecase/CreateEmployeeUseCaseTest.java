package com.techcorp.application.usecase;

import java.util.Optional;

import com.techcorp.domain.entity.JobPosition;
import com.techcorp.domain.entity.Employee;
import com.techcorp.domain.exception.EmployeeWithThatEmailExistsException;
import com.techcorp.domain.repository.EmployeeRepository;
import com.techcorp.application.dto.EmployeeDTO;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import org.mockito.ArgumentCaptor;

import static org.mockito.Mockito.*;


public class CreateEmployeeUseCaseTest {
    EmployeeRepository employeeRepository;
    CreateEmployeeUseCase createEmployeeUseCase;

    @BeforeEach
    void setUp() {
        employeeRepository = mock();
        createEmployeeUseCase = new CreateEmployeeUseCase(employeeRepository);
    }

    @Test
    void shouldSaveEmployeeInRepository() {
        ArgumentCaptor<Employee> employeeCaptor = ArgumentCaptor.forClass(Employee.class);
        when(employeeRepository.findEmployeeByEmail("jan.kowalski@gmail.com")).thenReturn(Optional.empty());

        EmployeeDTO employeeDTO = new EmployeeDTO("Jan", "Kowalski", "jan.kowalski@gmail.com", "Techcom", JobPosition.CEO);
        createEmployeeUseCase.execute(employeeDTO);

        verify(employeeRepository, times(1)).save(employeeCaptor.capture());
        Employee employeeCaptorValue = employeeCaptor.getValue();

        assertEquals("Jan Kowalski", employeeCaptorValue.getFullName());
        assertEquals("jan.kowalski@gmail.com", employeeCaptorValue.getEmail());
        assertEquals("Techcom", employeeCaptorValue.getCompany());
        assertEquals("Chief Executive Officer", employeeCaptorValue.getPositionName());
    }

    @Test
    void shouldThrowEmployeeWithThatEmailExistsException() {
        when(employeeRepository.findEmployeeByEmail("jan.kowalski@gmail.com")).thenReturn(Optional.of(new Employee("Jan", "Kowalski", "jan.kowalski@gmail.com", "Techcom", JobPosition.CEO)));

        EmployeeDTO employeeDTO = new EmployeeDTO("Jan", "Kowalski", "jan.kowalski@gmail.com", "Techcom", JobPosition.CEO);

        assertThrows(EmployeeWithThatEmailExistsException.class, () -> createEmployeeUseCase.execute(employeeDTO));
    }

}
