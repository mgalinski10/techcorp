package com.techcorp.application.dto;

import com.techcorp.domain.JobPosition;


public record EmployeeDTO(String firstName, String lastName, String email, String company, JobPosition position) {
}