package com.techcorp.domain.entity;

import java.util.List;

public record ImportSummary(List<Employee> importedEmployees, List<List<String>> errors) {
}
