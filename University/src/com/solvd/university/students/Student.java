package com.solvd.university.students;

import com.solvd.university.exception.PassExamException;
import com.solvd.university.exception.WrongMarkException;
import com.solvd.university.faculty.Faculty;
import com.solvd.university.exception.StudentException;
import com.solvd.university.university.University;

import java.util.Objects;


public abstract class Student {
    protected int idNumber;
    protected static int count;
    private String name;
    private int cardNumber;
    private int studyYear;
    private EducationType educationType;
    protected int cash;
    final private University university;
    final protected Faculty faculty;
    protected double averageMark;
    static {
        count = 0;
    }

    public Student(String name, int cardNumber, int studyYear, EducationType educationType,
                   University university, Faculty faculty) throws StudentException {
        count++;
        this.idNumber = count;
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

    protected final double passRetake(double practiceMark, double averageMark) throws PassExamException, WrongMarkException {
        if (averageMark >= 4){
            return averageMark;
        }
        else if (getExamCost() - getEducationCost() > cash){
            if (averageMark != 0) {
                System.out.println("Вы сдали экзамен на " + averageMark + " и это последняя пересдача на которую хватает денег со счета...");
            }
            return 0;
        }
        else {
            System.out.println("Вы сдали экзамен на " + averageMark + " и улетели на пересдачу...");
            double av = passExams(practiceMark);
            return passRetake(practiceMark, av);
        }
    }

    protected final double passRetake(int practiceMark, int averageMark) throws PassExamException, WrongMarkException {
        if (averageMark >= 4){
            return averageMark;
        }
        else if (getExamCost() - getEducationCost() > cash){
            if (averageMark != 0) {
                System.out.println("Вы сдали экзамен на " + averageMark + " и это последняя пересдача на которую хватает денег со счета...");
            }
            return 0;
        }
        else {
            System.out.println("Вы сдали экзамен на " + averageMark + " и улетели на пересдачу...");
            double av = passExams(practiceMark);
            return passRetake(practiceMark, av);
        }
    }

    public static boolean incrementCount(int newCount){
        if (newCount < 0){
            return false;
        }
        else {
            count += newCount;
            return true;
        }
    }

    abstract public double passExams(double practiceMark) throws WrongMarkException, PassExamException;

    public int getExamCost(){
        int examCost = 0;

        for (int i = 1; i <= faculty.getExams().size(); ++i)
        {
            examCost += faculty.getExams().get(i).getCost();
        }

        examCost += getEducationCost();

        return examCost;
    }

    private int getEducationCost(){
        if (this.educationType != EducationType.BUDGET){
            return university.getEducationCost();
        }
        else {
            return 0;
        }
    }

    public final boolean insertCash(int money){
        cash += money;
        return true;
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

    public void showSpeciality(){
        faculty.showSpeciality();
    }

    public Faculty getFaculty() {
        return faculty;
    }


    public static int getCount() {
        return count;
    }

    public double getAverageMark() {
        return averageMark;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return idNumber == student.idNumber && Objects.equals(name, student.name) && cardNumber == student.cardNumber
                && studyYear == student.studyYear && Objects.equals(educationType, student.educationType)
                && Objects.equals(university, student.university) && Objects.equals(faculty, student.faculty);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idNumber, name, cardNumber, studyYear, educationType
        , university, faculty);
    }

    @Override
    public String toString() {
        return "Студент " + name + ", номер студенческого " + idNumber + ", номер курса " + studyYear
                + ", университет " + university.getTitle() + ", факультет " + faculty.getTitle();
    }
}
