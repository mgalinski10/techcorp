package com.techcorp.infrastructure.csv;

import com.techcorp.application.service.csv.CsvValidator;
import com.techcorp.domain.entity.JobPosition;

import java.util.Arrays;
import java.util.List;

public class CsvEmployeeValidator implements CsvValidator {
    @Override
    public List<String> validate(List<String> token, int line) {
        List<String> availablePositions = Arrays.stream(JobPosition.values()).map(JobPosition::name).toList();

        if (token.size() == 1) {
            return null;
        }

        String position = token.get(4);
        int salary = Integer.parseInt(token.get(5));

        if (availablePositions.contains(position) && salary > 0) {
            return token;
        }

        StringBuilder invalidPositionMessage = new StringBuilder();

        if (!availablePositions.contains(position)) {
            invalidPositionMessage.append("Invalid job position: ").append(position);
        }

        StringBuilder invalidSalaryMessage = new StringBuilder();

        if (salary <= 0) {
            invalidSalaryMessage.append("Invalid salary: ").append(salary);
        }

        return List.of(invalidPositionMessage.toString(), invalidSalaryMessage.toString(), String.format("Line: %d", line));
    }
}
