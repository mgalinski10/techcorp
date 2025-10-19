package com.techcorp.infrastructure.csv;

import com.techcorp.application.service.csv.CsvReader;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.io.FileNotFoundException;
import java.util.List;
import java.util.stream.Stream;

public class CsvBufferedReaderTest {
    CsvReader reader;
    String FILE_PATH = "/home/michal/IdeaProjects/techcorp/src/test/java/com/techcorp/infrastructure/csv/employees.csv";

    @BeforeEach
    void setUp() {
        this.reader = new CsvBufferedReader();
    }

    @Test
    void shouldReturnLinesStream() throws FileNotFoundException {
        Stream<String> lines = reader.readLines(FILE_PATH);

        List<String> expectedLines = List.of("firstName,lastName,email,company,position,salary", "Jan,Kowalski,jan.kowalski@gmail.com,Techcorp,CEO,25000", "Adam,Nowak,adam.nowak@gmail.com,Techcorp,MANAGE,12000", "Piotr,Zieliński,piotr.zieliński@gmail.com,Inpost,DEVELOPE,8000");

        assertEquals(expectedLines, lines.toList());
    }
}
