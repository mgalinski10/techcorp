package com.techcorp.domain.entity;

public class EmployeeImportError {
    private final int line;
    private final String errorDescription;

    @Override
    public String toString() {
        return "EmployeeImportError{" +
                "line=" + line +
                ", errorDescription='" + errorDescription + '\'' +
                '}';
    }

    public EmployeeImportError(int line, String errorDescription) {
        this.line = line;
        this.errorDescription = errorDescription;
    }

    public int getLine() {
        return line;
    }

    public String getErrorDescription() {
        return errorDescription;
    }
}
