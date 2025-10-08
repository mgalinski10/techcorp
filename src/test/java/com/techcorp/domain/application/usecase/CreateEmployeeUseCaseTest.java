package com.techcorp.domain.application.usecase;

import com.techcorp.application.dto.EmployeeDTO;
import com.techcorp.application.usecase.CreateEmployeeUseCase;
import com.techcorp.domain.JobPosition;
import com.techcorp.domain.entity.Employee;
import com.techcorp.domain.exception.EmployeeWithThatEmailExistsException;
import com.techcorp.domain.repository.EmployeeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
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
