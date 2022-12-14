package com.solvd.university.specialities;

import java.util.ArrayList;

public class Speciality {
    private final String title;
    private ArrayList<Subject> subjects;

    public Speciality(String title, ArrayList<Subject> subjects) {
        this.title = title;
        this.subjects = subjects;
    }

    public void showSubjects(){
        System.out.println("Ваши предметы:");
        for(var i : this.getSubjects()){
            System.out.print(i.getTitle() + " ");
        }
        System.out.println();
    }

    public String getTitle() {
        return title;
    }

    public ArrayList<Subject> getSubjects() {
        return subjects;
    }

    public void setSubjects(ArrayList<Subject> subjects) {
        this.subjects = subjects;
    }
}
