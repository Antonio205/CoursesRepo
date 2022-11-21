package com.solvd.university.controller;

import com.solvd.university.educators.Assistant;
import com.solvd.university.educators.DepartmentHead;
import com.solvd.university.educators.Educator;
import com.solvd.university.educators.LaboratoryAssistant;
import com.solvd.university.exam.Exam;
import com.solvd.university.exception.StudentException;
import com.solvd.university.faculty.Faculty;
import com.solvd.university.specialities.HumanitarianSpeciality;
import com.solvd.university.specialities.TechnicalSpeciality;
import com.solvd.university.students.Bachelor;
import com.solvd.university.students.EducationType;
import com.solvd.university.students.Graduate;
import com.solvd.university.sublect.Subject;
import com.solvd.university.university.University;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args){
        try{
            Subject subject1 = new Subject("Math", 2);
            Subject subject2 = new Subject("Geometry", 4);
            ArrayList<Subject> subjects = new ArrayList<>();
            subjects.add(subject1);
            subjects.add(subject2);
            TechnicalSpeciality technicalSpeciality = new TechnicalSpeciality("MathLearning", subjects, 12);
            HumanitarianSpeciality humanitarianSpeciality = new HumanitarianSpeciality("some language",
                    subjects,12, "bebra");
            DepartmentHead e1 = new DepartmentHead("frgr", 12, 35, "rfr");
            Assistant e2 = new Assistant("regr", 5, 24, "Oleg");
            LaboratoryAssistant e3 = new LaboratoryAssistant("ju,i", 3, 14, 202);
            ArrayList<Educator> educators = new ArrayList<>();
            educators.add(e1);
            educators.add(e2);
            educators.add(e3);
            Exam exam1 = new Exam("ex",  56);
            Exam exam2 = new Exam("ex2",  24);
            ArrayList<Exam> exams = new ArrayList<>();
            exams.add(exam1);
            exams.add(exam2);
            Faculty faculty = new Faculty("bfk", exams, technicalSpeciality, educators);
            Faculty faculty2 = new Faculty("bfk", exams, humanitarianSpeciality, educators);
            ArrayList<Faculty> faculties = new ArrayList<>();
            faculties.add(faculty);
            faculties.add(faculty2);
            University bsu = new University("BSU", 45, "carol", faculties);
            Bachelor bachelor = new Bachelor(21, "anton", 45,
                    3, EducationType.BUDGET, bsu, faculty, "gre");
            System.out.println("Стоимость экзамена: "  + bachelor.getExamCost());
            bachelor.insertCash(90);
            System.out.println("Балaнс на данный момент: " + bachelor.getCash());
            bachelor.passExams();
            System.out.println("Ваш средний балл - " + bachelor.getAverageMark());
            if (bachelor.getAverageMark() >= 4){
                    System.out.println("Вы успешно сдали экзамены");
            }
            else
            {
                    System.out.println("Вы завалили экзамены");
            }

            Graduate graduate = new Graduate(12, "rge", 45, 2,
                    EducationType.PAID, bsu, faculty2, "btr", 8);
            graduate.insertCash(150);
                graduate.passExams();
                System.out.println("Средняя оценка по факультету: " + faculty.getAverage());
                System.out.println("Средняя оценка по университету: " + bsu.getAverage());
            bachelor.showSpeciality();
        }
        catch (StudentException exp){
            System.out.println(exp.getMessage());
        }
        catch (NullPointerException exp){
            System.out.println(exp.getMessage());
        }
    }
}
