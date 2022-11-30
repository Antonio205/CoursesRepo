package com.solvd.university.educators;

import com.solvd.university.controller.EducatorBuilder;

public class Assistant extends Educator{
    private String mentor;


    public Assistant(EducatorBuilder builder) {
        super(builder);
    }

    public Assistant(String name, int experience, int salary, String mentor) {
        super(name, experience, salary);
        this.mentor = mentor;
    }

    public String getMentor() {
        return mentor;
    }

    public void setMentor(String mentor) {
        this.mentor = mentor;
    }
}