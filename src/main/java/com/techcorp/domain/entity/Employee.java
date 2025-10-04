package com.techcorp.domain.entity;

import com.techcorp.domain.JobPosition;

import java.util.Objects;

public class Employee {
    private String firstName;
    private String lastName;
    private String email;
    private JobPosition position;


    public Employee(String firstName, String lastName, String email, JobPosition position) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.position = position;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Employee employee)) return false;
        return Objects.equals(this.email, employee.getEmail());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getEmail());
    }

    @Override
    public String toString() {
        return "Employee{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", position=" + position +
                '}';
    }

    public String getFullName() {
        return firstName + " " + lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getPositionName() {
        return position.getName();
    }

    public int getSalary() {
        return position.getSalary();
    }

    public int getLevel() {
        return position.getLevel();
    }

}

