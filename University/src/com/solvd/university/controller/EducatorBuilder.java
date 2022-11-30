package com.solvd.university.controller;

import com.solvd.university.educators.Assistant;
import com.solvd.university.educators.DepartmentHead;
import com.solvd.university.educators.LaboratoryAssistant;

public class EducatorBuilder {

    private String name;
    private int experience;
    private int salary;


    public EducatorBuilder(String name) {
        this.name = name;
    }

    public EducatorBuilder setExperience(int experience){
        this.experience = experience;
        return this;
    }

    public EducatorBuilder setSalary(int salary){
        this.salary = salary;
        return this;
    }

    public Assistant createAssistant(){
        return new Assistant(this);
    }

    public DepartmentHead createDepartmentHead(){
        return new DepartmentHead(this);
    }

    public LaboratoryAssistant createLaboratoryAssistant(){
        return new LaboratoryAssistant(this);
    }

    public String getName() {
        return name;
    }

    public int getExperience() {
        return experience;
    }

    public int getSalary() {
        return salary;
    }
}
