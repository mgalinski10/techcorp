package com.techcorp.application.service.csv;

import java.util.List;

public interface CsvTokenizer {
    List<String> tokenize(String line);
}
