package com.techcorp.infrastracture;

import com.techcorp.application.service.parser.CsvParser;
import com.techcorp.domain.entity.ImportSummary;
import com.techcorp.infrastracture.parser.CsvEmployeeDataParser;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CsvEmployeeDataParserTest {
    CsvParser csvEmployeeDataParser;

    @BeforeEach
    void setUp() {
        csvEmployeeDataParser = new CsvEmployeeDataParser();
    }

    @Test
    void shouldPrintLinesFromFile() {
        String filePath = "/home/michal/IdeaProjects/techcorp/src/test/java/com/techcorp/infrastracture/employee_list.csv";
        ImportSummary result = csvEmployeeDataParser.parse(filePath);


    }
}
