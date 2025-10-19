package com.techcorp.infrastructure.csv;

import com.techcorp.application.service.csv.CsvReader;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.stream.Stream;

public class CsvBufferedReader implements CsvReader {
    @Override
    public Stream<String> readLines(String path) throws FileNotFoundException {
        BufferedReader reader = new BufferedReader(new FileReader(path));
        return reader.lines();
    }
}
