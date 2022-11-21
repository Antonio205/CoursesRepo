package com.solvd.university.model.faculty;

import com.solvd.university.model.educators.Educator;
import com.solvd.university.model.exam.Exam;
import com.solvd.university.exception.StudentException;
import com.solvd.university.model.specialities.Speciality;
import com.solvd.university.model.students.Student;

import java.util.ArrayList;

public class Faculty {
    private String title;
    private ArrayList<Exam> exams;
    private ArrayList<Student> students;
    private ArrayList<Educator> educators;
    private Speciality speciality;


    public Faculty(String title, ArrayList<Exam> exams,
                    Speciality speciality, ArrayList<Educator> educators) {
        this.title = title;
        this.exams = exams;
        this.students = new ArrayList<>();
        this.speciality = speciality;
        this.educators = educators;
    }

    public void showSpeciality(){
        System.out.println("Ваша специальность: " + speciality.getTitle());
        speciality.showSubjects();
    }

    public boolean isSmbPassExam(){
        for(var i : students){
            if (i.getExamMarks() != null)
            {
                return true;
            }
        }
        return false;
    }

    public int getAverage() throws StudentException {
        if (!isSmbPassExam()){
            throw new StudentException("Никто из студентов не сдавал экзамены");
        }
        int sum = 0;
        int t = 0;
        for (var i : students){
            if (i.getExamMarks()!= null) {
                sum += i.getAverageMark();
                t++;
            }
        }

        return sum / t;
    }

    public void addStudent(Student student){
        students.add(student);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public ArrayList<Exam> getExams() {
        return exams;
    }

    public void setExams(ArrayList<Exam> exams) {
        this.exams = exams;
    }

    public ArrayList<Student> getStudents() {
        return students;
    }

    public void setStudents(ArrayList<Student> students) {
        this.students = students;
    }

    public void acceptStudent(Student student) {
        this.students.add(student);
    }

    public ArrayList<Educator> getEducators() {
        return educators;
    }

    public void setEducators(ArrayList<Educator> educators) {
        this.educators = educators;
    }


    public Speciality getSpeciality() {
        return speciality;
    }

    public void setSpeciality(Speciality speciality) {
        this.speciality = speciality;
    }

}
