package com.techcorp.infrastructure.csv;

import java.util.ArrayList;
import java.util.List;

import com.techcorp.application.service.csv.CsvMapper;
import com.techcorp.domain.entity.Employee;
import com.techcorp.domain.entity.ImportSummary;
import com.techcorp.domain.entity.JobPosition;


public class CsvEmployeeMapper implements CsvMapper<ImportSummary> {
    int MAX_ERROR_TOKEN_LENGTH = 3;


    @Override
    public ImportSummary map(List<List<String>> tokensAfterValidation) {
        List<Employee> employees = new ArrayList<>();
        List<List<String>> errors = new ArrayList<>();

        tokensAfterValidation.forEach(t -> {
            if (t.size() <= MAX_ERROR_TOKEN_LENGTH) {
                errors.add(t);
            } else {
                JobPosition position = JobPosition.valueOf(t.get(4));
                Employee newEmployee = new Employee(t.get(0), t.get(1), t.get(2), t.get(3), position);
                employees.add(newEmployee);
            }
        });

        return new ImportSummary(employees, errors);
    }


}
