package com.techcorp.application.service.csv;

import java.util.List;
import java.util.Optional;

public interface CsvMapper<T> {
    T map(List<List<String>> row);
}
