package com.techcorp.infrastructure.csv;

import com.techcorp.application.service.csv.CsvTokenizer;

import java.util.Arrays;
import java.util.List;

public class CsvColumnTokenizer implements CsvTokenizer {
    @Override
    public List<String> tokenize(String line) {
        return Arrays.stream(line.split(",")).toList();
    }
}
