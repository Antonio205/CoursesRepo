package com.solvd.university.students;

import com.solvd.university.exception.PassExamException;
import com.solvd.university.exception.WrongMarkException;
import com.solvd.university.faculty.Faculty;
import com.solvd.university.exception.StudentException;
import com.solvd.university.university.University;

import java.util.ArrayList;
import java.util.Random;

public class Graduate extends Student {

    private String candidateWorkTheme;
    private int workHours;

    public Graduate(String name, int cardNumber, int studyYear,
                    EducationType educationType, University university, Faculty faculty) throws StudentException {
        super(name, cardNumber, studyYear, educationType, university, faculty);
    }

    public Graduate(String name, int cardNumber, int studyYear,
                    EducationType educationType, University university, Faculty faculty, String candidateWorkTheme, int workHours) throws StudentException {
        super(name, cardNumber, studyYear, educationType, university, faculty);
        this.candidateWorkTheme = candidateWorkTheme;
        this.workHours = workHours;
    }

    @Override
    public double passExams(double practiceMark) throws WrongMarkException, PassExamException {
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

            if (n < 9){
                n += 2;
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
