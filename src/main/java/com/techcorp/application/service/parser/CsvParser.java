package com.techcorp.application.service.parser;

import com.techcorp.domain.entity.ImportSummary;

public interface CsvParser {
    ImportSummary parse(String filePath);
}
