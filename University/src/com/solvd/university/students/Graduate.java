package com.solvd.university.students;

import com.solvd.university.faculty.Faculty;
import com.solvd.university.exception.StudentException;
import com.solvd.university.university.University;

import java.util.ArrayList;
import java.util.Random;

public class Graduate extends Student {
    private String candidateWorkTheme;
    private int workHours;

    public Graduate(int idNumber, String name, int cardNumber, int studyYear,
                    EducationType educationType, University university, Faculty faculty, String candidateWorkTheme, int workHours) throws StudentException {
        super(idNumber, name, cardNumber, studyYear, educationType, university, faculty);
        this.candidateWorkTheme = candidateWorkTheme;
        this.workHours = workHours;
    }

    @Override
    public void passExams() throws StudentException {
        if (cash < getExamCost()){
            throw new StudentException("Ошибка! Недостаточно денег для сдачи экзамена");
        }
        cash -= getExamCost();
        ArrayList<Double> examMarks = new ArrayList<Double>();
        for(int i = 0; i < faculty.getExams().size(); ++i){
            Random rand = new Random();
            int n = rand.nextInt(11);
            n += 2;
            if (n > 10){
                n = 10;
            }
            examMarks.add((double)n);
        }
        this.examMarks = examMarks;
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
