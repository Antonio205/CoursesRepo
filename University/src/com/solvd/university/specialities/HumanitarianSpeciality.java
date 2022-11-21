package com.solvd.university.specialities;

import com.solvd.university.sublect.Subject;

import java.util.ArrayList;

public class HumanitarianSpeciality extends Speciality{
    private int essaysNumber;
    private String courseworkTheme;

    public HumanitarianSpeciality(String title, ArrayList<Subject> subjects, int essaysNumber, String courseworkTheme) {
        super(title, subjects);
        this.essaysNumber = essaysNumber;
        this.courseworkTheme = courseworkTheme;
    }


    public int getEssaysNumber() {
        return essaysNumber;
    }

    public void setEssaysNumber(int essaysNumber) {
        this.essaysNumber = essaysNumber;
    }

    public String getCourseworkTheme() {
        return courseworkTheme;
    }

    public void setCourseworkTheme(String courseworkTheme) {
        this.courseworkTheme = courseworkTheme;
    }
}
