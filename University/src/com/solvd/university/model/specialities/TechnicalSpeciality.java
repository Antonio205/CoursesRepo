package com.solvd.university.model.specialities;

import com.solvd.university.model.sublect.Subject;

import java.util.ArrayList;

public class TechnicalSpeciality extends Speciality{
    private int laboratoriesHours;

    public TechnicalSpeciality(String title, ArrayList<Subject> subjects, int laboratoriesHours) {
        super(title, subjects);
        this.laboratoriesHours = laboratoriesHours;
    }


    public int getLaboratoriesHours() {
        return laboratoriesHours;
    }

    public void setLaboratoriesHours(int laboratoriesHours) {
        this.laboratoriesHours = laboratoriesHours;
    }
}
