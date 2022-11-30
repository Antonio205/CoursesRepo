package com.solvd.university.educators;

import com.solvd.university.controller.EducatorBuilder;

public class LaboratoryAssistant extends Educator{
    private int auditoriumNum;

    public LaboratoryAssistant(EducatorBuilder builder) {
        super(builder);
    }

    public LaboratoryAssistant(String name, int experience, int salary, int auditoriumNum) {
        super(name, experience, salary);
        this.auditoriumNum = auditoriumNum;
    }

    public int getAuditoriumNum() {
        return auditoriumNum;
    }

    public void setAuditoriumNum(int auditoriumNum) {
        this.auditoriumNum = auditoriumNum;
    }
}