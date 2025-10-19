package com.techcorp.application.service.csv;

import java.util.List;

public interface CsvValidator {
    List<String> validate(List<String> token, int line);
}
