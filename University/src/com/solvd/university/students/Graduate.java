package com.solvd.university.students;

import com.solvd.university.faculty.Faculty;
import com.solvd.university.exception.StudentException;
import com.solvd.university.university.University;

public class Graduate extends Student {
    private String candidateWorkTheme;
    private int workHours;

    public Graduate(int idNumber, String name, int cardNumber, int studyYear,
                    EducationType educationType, University university, Faculty faculty, String candidateWorkTheme, int workHours) throws StudentException {
        super(idNumber, name, cardNumber, studyYear, educationType, university, faculty);
        this.candidateWorkTheme = candidateWorkTheme;
        this.workHours = workHours;
    }


    public String getCandidateWorkTheme() {
        return candidateWorkTheme;
    }

    public void setCandidateWorkTheme(String candidateWorkTheme) {
        this.candidateWorkTheme = candidateWorkTheme;
    }

    public int getWorkHours() {
        return workHours;
    }

    public void setWorkHours(int workHours) {
        this.workHours = workHours;
    }




}
