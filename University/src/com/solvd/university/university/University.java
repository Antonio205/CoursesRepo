package com.solvd.university.university;

import com.solvd.university.educators.Educator;
import com.solvd.university.exception.StudentException;
import com.solvd.university.faculty.Faculty;
import com.solvd.university.students.Student;

import java.util.ArrayList;
import java.util.Objects;


public class University implements GetAverage {
    private String title;
    private int educationCost;
    private String rectorName;
    private ArrayList<Faculty> faculties;

    public University(String title, int educationCost, String rectorName, ArrayList<Faculty> faculties) {
        this.title = title;
        this.educationCost = educationCost;
        this.rectorName = rectorName;
        this.faculties = faculties;
    }

    public boolean containFaculty(Faculty faculty){
        for(var i : faculties){
            if (faculty.equals(i)) {
                return true;
            }
        }

        return false;
    }

    public double getAverage() throws StudentException {
        double sum = 0;
        int num = 0;
        for (var i : faculties){
            ArrayList<Student> students = i.getStudents();
            for(var t : students){
                if (t.getAverageMark() != 0) {
                    sum += t.getAverageMark();
                    ++num;
                }
            }
        }

        return sum / (double)num;
    }

    public double getAverageExperience(){
        double sum = 0;
        int num = 0;
        for (var i : faculties){
            ArrayList<Educator> educators = i.getEducators();
            for(var t : educators){
                sum += t.getExperience();
                ++num;
            }
        }

        return sum / (double)num;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getEducationCost() {
        return educationCost;
    }

    public void setEducationCost(int educationCost) {
        this.educationCost = educationCost;
    }

    public String getRectorName() {
        return rectorName;
    }

    public void setRectorName(String rectorName) {
        this.rectorName = rectorName;
    }

    public ArrayList<Faculty> getFaculties() {
        return faculties;
    }

    public void setFaculties(ArrayList<Faculty> faculties) {
        this.faculties = faculties;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        University university = (University) o;
        return Objects.equals(title, university.title) && educationCost == university.educationCost
                && Objects.equals(rectorName, university.rectorName) && Objects.equals(faculties, university.faculties);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, educationCost, rectorName, faculties);
    }

    @Override
    public String toString() {
        return "Университет " + getTitle() + ", имя ректора " + getRectorName() +
                ", стоимость обучения " + getEducationCost();
    }
}
