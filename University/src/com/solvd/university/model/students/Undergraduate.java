package com.solvd.university.model.students;

import com.solvd.university.model.faculty.Faculty;
import com.solvd.university.exception.StudentException;
import com.solvd.university.model.university.University;

public class Undergraduate extends Student{

    private String dissertationTheme;

    public Undergraduate (int idNumber, String name, int cardNumber, int studyYear,
                          EducationType educationType, University university, Faculty faculty, String dissertationTheme) throws StudentException {
        super(idNumber, name, cardNumber, studyYear, educationType, university, faculty);
        this.dissertationTheme = dissertationTheme;
    }


    public String getDissertationTheme() {
        return dissertationTheme;
    }

    public void setDissertationTheme(String dissertationTheme) {
        this.dissertationTheme = dissertationTheme;
    }
}
