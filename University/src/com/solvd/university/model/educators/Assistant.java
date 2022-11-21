package com.solvd.university.model.educators;

public class Assistant extends Educator{
    private String mentor;

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
