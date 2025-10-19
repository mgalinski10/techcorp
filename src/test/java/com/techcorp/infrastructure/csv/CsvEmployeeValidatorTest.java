package com.techcorp.infrastructure.csv;

import com.techcorp.application.service.csv.CsvValidator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

public class CsvEmployeeValidatorTest {
    CsvValidator validator;

    @BeforeEach
    void setUp() {
        this.validator = new CsvEmployeeValidator();
    }

    @Test
    void shouldReturnErrorMessages() {
        List<String> wrongToken = List.of("Piotr", "Zieliński", "piotr.zieliński@gmail.com", "Inpost", "DEVELOPE", "-1");

        List<String> errors = validator.validate(wrongToken, 1);

        List<String> expectedErrors = List.of("Invalid job position: DEVELOPE", "Invalid salary: -1");

        assertEquals(expectedErrors, errors);
    }

    @Test
    void shouldReturnCorrectToken() {
        List<String> correctToken = List.of("Piotr", "Zieliński", "piotr.zieliński@gmail.com", "Inpost", "DEVELOPER", "8000");

        List<String> token = validator.validate(correctToken, 1);

        assertEquals(correctToken, token);
    }
}
