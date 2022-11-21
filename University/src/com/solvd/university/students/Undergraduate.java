package com.solvd.university.students;

import com.solvd.university.faculty.Faculty;
import com.solvd.university.exception.StudentException;
import com.solvd.university.university.University;

import java.util.ArrayList;
import java.util.Random;

public class Undergraduate extends Student{

    private String dissertationTheme;

    public Undergraduate (int idNumber, String name, int cardNumber, int studyYear,
                          EducationType educationType, University university, Faculty faculty, String dissertationTheme) throws StudentException {
        super(idNumber, name, cardNumber, studyYear, educationType, university, faculty);
        this.dissertationTheme = dissertationTheme;
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
            if(n != 10){
                ++n;
            }
            examMarks.add((double)n);
        }
        this.examMarks = examMarks;
    }


    public String getDissertationTheme() {
        return dissertationTheme;
    }

    public void setDissertationTheme(String dissertationTheme) {
        this.dissertationTheme = dissertationTheme;
    }
}
