package com.techcorp.application.usecase;

import com.techcorp.domain.entity.ImportSummary;
import com.techcorp.application.service.csv.CsvMapper;
import com.techcorp.application.service.csv.CsvReader;
import com.techcorp.application.service.csv.CsvTokenizer;
import com.techcorp.application.service.csv.CsvValidator;
import com.techcorp.infrastructure.csv.CsvBufferedReader;
import com.techcorp.infrastructure.csv.CsvColumnTokenizer;
import com.techcorp.infrastructure.csv.CsvEmployeeMapper;
import com.techcorp.infrastructure.csv.CsvEmployeeValidator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class ImportEmployeesFromCsvUseCaseTest {
    ImportEmployeesFromCsvUseCase importEmployeesFromCsvUseCase;
    CsvReader reader;
    CsvTokenizer tokenizer;
    CsvValidator validator;
    CsvMapper<ImportSummary> mapper;

    @BeforeEach
    void setUp() {
        this.reader = new CsvBufferedReader();
        this.tokenizer = new CsvColumnTokenizer();
        this.validator = new CsvEmployeeValidator();
        this.mapper = new CsvEmployeeMapper();
    }

    @Test
    void shouldImportEmployeesFromCsv() {
        String FILE_PATH = "/home/michal/IdeaProjects/techcorp/src/test/java/com/techcorp/infrastructure/csv/employees.csv";
        this.importEmployeesFromCsvUseCase = new ImportEmployeesFromCsvUseCase(reader, tokenizer, validator, mapper);

        ImportSummary result = importEmployeesFromCsvUseCase.execute(FILE_PATH);

        System.out.println(result);
    }
}
