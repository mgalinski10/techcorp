package com.techcorp.domain;

public enum JobPosition {
    CEO("Chief Executive Officer", 25000, 1),
    VP("Vice President", 18000, 2),
    MANAGER("Manager", 12000, 3),
    DEVELOPER("Developer", 8000, 4),
    INTERNSHIP("Intern", 3000, 5);

    private final String name;
    private final int salary;
    private final int level;

    JobPosition(String name, int salary, int level) {
        this.salary = salary;
        this.name = name;
        this.level = level;
    }

    public String getName() {
        return name;
    }

    public int getSalary() {
        return salary;
    }

    public int getLevel() {
        return level;
    }

}
