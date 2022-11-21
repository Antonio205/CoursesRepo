package com.solvd.university.students;

import com.solvd.university.faculty.Faculty;
import com.solvd.university.exception.StudentException;
import com.solvd.university.university.University;

import java.util.ArrayList;
import java.util.Random;

public abstract class Student {
    private int idNumber;
    private String name;
    private int cardNumber;
    private int studyYear;
    private EducationType educationType;
    private int cash;
    final private University university;
    final private Faculty faculty;
    private ArrayList<Integer> examMarks;

    public Student(int idNumber, String name, int cardNumber, int studyYear, EducationType educationType,
                   University university, Faculty faculty) throws StudentException {
        this.idNumber = idNumber;
        this.name = name;
        this.cardNumber = cardNumber;
        this.studyYear = studyYear;
        this.educationType = educationType;
        this.cash = 0;
        this.university = university;
        if (!this.university.containFaculty(faculty)){
            throw new StudentException("Ошибка! Указанного факультета нет в университете");
        }
        this.faculty = faculty;
        faculty.addStudent(this);
    }

    public void passExams() throws StudentException {
        if (cash < getExamCost()){
            throw new StudentException("Ошибка! Недостаточно денег для сдачи экзамена");
        }
        cash -= getExamCost();
        ArrayList<Integer> examMarks = new ArrayList<Integer>();
        for(int i =0; i < faculty.getExams().size(); ++i){
            Random rand = new Random();
            int n = rand.nextInt(11);
            examMarks.add(n);
        }
        this.examMarks = examMarks;
    }

    public void showSpeciality(){
        faculty.showSpeciality();
    }

    public void showMarks() {
        if (examMarks == null){
            throw new NullPointerException("Ошибка! Студент не сдал экзаменов");
        }
        for(var i : examMarks){
            System.out.print(i +  " ");
        }
        System.out.println();
    }

    public int getExamCost(){
        int examCost = 0;

        for (var i : faculty.getExams())
        {
            examCost += i.getCost();
        }

        if (this.educationType != EducationType.BUDGET)
        {
            examCost += university.getEducationCost();
        }

        return examCost;
    }

    public void insertCash(int money){
        cash += money;
    }

    public EducationType getEducationType() {
        return educationType;
    }

    public void setEducationType(EducationType educationType) {
        this.educationType = educationType;
    }

    public int getStudyYear() {
        return studyYear;
    }

    public void setStudyYear(int studyYear) {
        this.studyYear = studyYear;
    }

    public int getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(int idNumber) {
        this.idNumber = idNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(int cardNumber) {
        this.cardNumber = cardNumber;
    }

    public int getCash() {
        return cash;
    }

    public University getUniversity() {
        return university;
    }

    public Faculty getFaculty() {
        return faculty;
    }

    public int getAverageMark() {
        if (examMarks == null){
            throw new NullPointerException("Ошибка! Студент не сдал экзамены");
        }
        int sum = 0;
        for (var i : examMarks){
            sum += i;
        }
        return sum / examMarks.size();
    }

    public ArrayList<Integer> getExamMarks() {
        return examMarks;
    }

}
