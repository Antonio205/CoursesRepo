package com.solvd.university.educators;

import com.solvd.university.controller.EducatorBuilder;

public abstract class Educator {
    private String name;
    private int experience;
    private int salary;

    public Educator(EducatorBuilder builder) {
        this.name = builder.getName();
        this.experience = builder.getExperience();
        this.salary = builder.getSalary();
    }

    public Educator(String name, int experience, int salary) {
        this.name = name;
        this.experience = experience;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }
}
