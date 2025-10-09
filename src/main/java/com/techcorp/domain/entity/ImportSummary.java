package com.techcorp.domain.entity;

import java.util.List;

public class ImportSummary {
    private final List<Employee> importedEmployees;
    private final List<EmployeeImportError> errors;

    public ImportSummary(List<Employee> importedEmployees, List<EmployeeImportError> errors) {
        this.importedEmployees = importedEmployees;
        this.errors = errors;
    }

    public List<Employee> getImportedEmployees() {
        return importedEmployees;
    }

    public List<EmployeeImportError> getErrors() {
        return errors;
    }
}
