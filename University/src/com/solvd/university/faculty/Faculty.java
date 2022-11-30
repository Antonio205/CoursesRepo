package com.solvd.university.faculty;

import com.solvd.university.university.Averageable;
import com.solvd.university.educators.Educator;
import com.solvd.university.exam.Exam;
import com.solvd.university.exception.StudentException;
import com.solvd.university.specialities.Speciality;
import com.solvd.university.students.Student;

import java.util.ArrayList;
import java.util.Objects;

public final class Faculty implements Averageable {
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
            if (i.getAverageMark() != 0)
            {
                return true;
            }
        }
        return false;
    }

    public double getAverageExperience(){
        double sum = 0;
        for(var i : educators){
            sum += i.getExperience();
        }

        return sum / (double)educators.size();
    }

    public double getAverage() throws StudentException {
        if (!isSmbPassExam()){
            throw new StudentException("Никто из студентов не сдавал экзамены");
        }
        double sum = 0;
        int t = 0;
        for (var i : students){
            if (i.getAverageMark() != 0) {
                sum += i.getAverageMark();
                t++;
            }
        }

        return sum / (double)t;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Faculty faculty = (Faculty) o;
        return Objects.equals(title, faculty.title) && Objects.equals(exams, faculty.exams)
                && Objects.equals(students, faculty.students) && Objects.equals(educators, faculty.educators)
                && Objects.equals(speciality, faculty.speciality);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, exams, students, educators, speciality);
    }

    @Override
    public String toString() {
        return "Факультет " + getTitle() + ", специальность " + getSpeciality().getTitle();
    }

}
