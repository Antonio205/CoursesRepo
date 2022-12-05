package com.solvd.university.students;

import com.solvd.university.exception.PassExamException;
import com.solvd.university.exception.WrongMarkException;
import com.solvd.university.faculty.Faculty;
import com.solvd.university.exception.StudentException;
import com.solvd.university.university.University;

import java.util.ArrayList;
import java.util.Random;

public class Undergraduate extends Student {

    private String dissertationTheme;

    public Undergraduate (String name, int cardNumber, int studyYear,
                          EducationType educationType, University university, Faculty faculty) throws StudentException {
        super(name, cardNumber, studyYear, educationType, university, faculty);
    }

    public Undergraduate (String name, int cardNumber, int studyYear,
                          EducationType educationType, University university, Faculty faculty, String dissertationTheme) throws StudentException {
        super(name, cardNumber, studyYear, educationType, university, faculty);
        this.dissertationTheme = dissertationTheme;
    }

    @Override
    public double passExams(double practiceMark) throws PassExamException, WrongMarkException {
        if (cash < getExamCost()){
            throw new PassExamException("Ошибка! Недостаточно денег для сдачи экзамена");
        }
        if (practiceMark <= 0 || practiceMark > 10){
            throw new WrongMarkException("Балл за практику должен быть от одного до десяти");
        }

        cash -= getExamCost();
        ArrayList<Double> examMarks = new ArrayList<Double>();
        for(int i = 0; i < faculty.getExams().size(); ++i){
            Random rand = new Random();
            int n = rand.nextInt(11);
            if(n != 10){
                ++n;
            }
            examMarks.add(((double)n + (double)practiceMark) / 2);
        }

        double sum = 0;
        for (var i : examMarks){
            sum += i;
        }

        double averageMark = passRetake(practiceMark, sum / examMarks.size());

        if (averageMark == 0){
            return 0;
        }

        this.averageMark = averageMark;
        return this.averageMark;
    }


    public String getDissertationTheme() {
        return dissertationTheme;
    }

    public void setDissertationTheme(String dissertationTheme) {
        this.dissertationTheme = dissertationTheme;
    }
}
