package com.techcorp.infrastructure.csv;

import com.techcorp.application.service.csv.CsvTokenizer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

public class CsvColumnTokenizerTest {
    CsvTokenizer tokenizer;
    String TEST_LINE = "Jan,Kowalski,jan.kowalski@gmail.com,Techcorp,CEO,25000";

    @BeforeEach
    void setUp() {
        this.tokenizer = new CsvColumnTokenizer();
    }

    @Test
    void shouldSplitLineIntoTokens() {
        List<String> tokens = tokenizer.tokenize(TEST_LINE);

        List<String> expectedTokens = List.of("Jan", "Kowalski", "jan.kowalski@gmail.com", "Techcorp", "CEO", "25000");

        assertEquals(expectedTokens, tokens);
    }
}
