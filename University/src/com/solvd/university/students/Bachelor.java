package com.solvd.university.students;

import com.solvd.university.faculty.Faculty;
import com.solvd.university.exception.StudentException;
import com.solvd.university.university.University;

import java.util.ArrayList;
import java.util.Random;

public class Bachelor extends Student {

    private String graduateTheme;

    public Bachelor(String name, int cardNumber, int studyYear, EducationType educationType,
                    University university, Faculty faculty, String graduateTheme) throws StudentException {
        super(name, cardNumber, studyYear, educationType, university, faculty);
        this.graduateTheme = graduateTheme;
    }

    @Override
    public double passExams(double practiceMark) throws StudentException {
        if (cash < getExamCost()){
            throw new StudentException("Ошибка! Недостаточно денег для сдачи экзамена");
        }
        if (practiceMark <= 0 || practiceMark > 10){
            throw new IllegalArgumentException("Балл за практику должен быть от одного до десяти");
        }

        cash -= getExamCost();
        ArrayList<Double> examMarks = new ArrayList<Double>();
        for(int i = 0; i < faculty.getExams().size(); ++i){
            Random rand = new Random();
            int n = rand.nextInt(11);
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


    public String getGraduateTheme() {
        return graduateTheme;
    }

    public void setGraduateTheme(String graduateTheme) {
        this.graduateTheme = graduateTheme;
    }
}
