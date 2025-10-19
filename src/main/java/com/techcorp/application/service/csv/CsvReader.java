package com.techcorp.application.service.csv;

import java.io.FileNotFoundException;
import java.util.stream.Stream;

public interface CsvReader {
    Stream<String> readLines(String path) throws FileNotFoundException;
}
