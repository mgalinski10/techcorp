package com.techcorp.application.usecase;

import java.io.FileNotFoundException;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;

import com.techcorp.application.service.csv.CsvValidator;
import com.techcorp.application.service.csv.CsvMapper;
import com.techcorp.application.service.csv.CsvReader;
import com.techcorp.application.service.csv.CsvTokenizer;
import com.techcorp.domain.entity.ImportSummary;


public class ImportEmployeesFromCsvUseCase {
    CsvReader reader;
    CsvTokenizer tokenizer;
    CsvValidator validator;
    CsvMapper<ImportSummary> mapper;

    public ImportEmployeesFromCsvUseCase(CsvReader reader, CsvTokenizer tokenizer, CsvValidator validator, CsvMapper<ImportSummary> mapper) {
        this.reader = reader;
        this.tokenizer = tokenizer;
        this.validator = validator;
        this.mapper = mapper;
    }

    public ImportSummary execute(String path) {
        AtomicInteger lineNumber = new AtomicInteger(2);

        try (Stream<String> lines = reader.readLines(path)) {
            List<List<String>> linesAfterValidation = lines
                    .skip(1)
                    .filter(l -> !l.isBlank())
                    .map(line -> {
                        int currentLine = lineNumber.getAndIncrement();
                        List<String> tokens = tokenizer.tokenize(line);
                        return validator.validate(tokens, currentLine);

                    })
                    .toList();

            ImportSummary summary = mapper.map(linesAfterValidation);

            System.out.println(summary);
            return summary;
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
