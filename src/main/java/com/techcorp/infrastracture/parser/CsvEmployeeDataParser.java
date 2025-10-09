package com.techcorp.infrastracture.parser;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;

import com.techcorp.domain.JobPosition;
import com.techcorp.domain.entity.Employee;
import com.techcorp.domain.entity.EmployeeImportError;
import com.techcorp.domain.entity.ImportSummary;
import com.techcorp.application.service.parser.CsvParser;


public class CsvEmployeeDataParser implements CsvParser {
    private final List<EmployeeImportError> errors = new ArrayList<>();
    private int lineNumber = 1;

    @Override
    public ImportSummary parse(String filePath) {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            List<Employee> employees = br.lines()
                    .skip(1)
                    .map(line -> {
                        lineNumber++;

                        String[] props = line.split(",");
                        String jobPositionProps = props[4];

                        List<String> existingPositions = Arrays.stream(JobPosition.values()).map(JobPosition::name).toList();

                        if (existingPositions.stream().noneMatch(p -> p.equals(jobPositionProps))) {
                            errors.add(new EmployeeImportError(lineNumber, String.format("Wrong position: '%s' in line: %d", jobPositionProps, lineNumber)));
                            return null;
                        }

                        return new Employee(props[0], props[1], props[2], props[3], JobPosition.valueOf(jobPositionProps));
                    })
                    .filter(Objects::nonNull)
                    .toList();

            return new ImportSummary(employees, errors);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

