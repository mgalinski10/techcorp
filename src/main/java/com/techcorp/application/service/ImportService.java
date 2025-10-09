package com.techcorp.application.service;

import com.techcorp.application.service.parser.CsvParser;
import com.techcorp.domain.entity.ImportSummary;

public class ImportService {
    private final CsvParser csvParser;

    public ImportService(CsvParser csvParser) {
        this.csvParser = csvParser;
    }

    public ImportSummary importEmployeesFromCsv(String filePath) {
        return csvParser.parse(filePath);
    }
}
