package com.solvd.university.specialities;

import java.util.HashSet;

public class Speciality {
    private final String title;
    private HashSet<Subject> subjects;

    public Speciality(String title, HashSet<Subject> subjects) {
        this.title = title;
        this.subjects = subjects;
    }

    public void showSubjects(){
        System.out.println("Ваши предметы:");
        for(var i : this.getSubjects()) {
            System.out.print(i.getTitle() + " ");
        }
        System.out.println();
    }

    public String getTitle() {
        return title;
    }

    public HashSet<Subject> getSubjects() {
        return subjects;
    }

    public void setSubjects(HashSet<Subject> subjects) {
        this.subjects = subjects;
    }
}
