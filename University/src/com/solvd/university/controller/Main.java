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
import com.solvd.university.specialities.Subject;
import com.solvd.university.university.University;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        try{
            Subject subject1 = new Subject("Математика", 2);
            Subject subject2 = new Subject("Геометрия", 4);
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
            Faculty faculty = new Faculty("ФПМИ", exams, technicalSpeciality, educators);
            Faculty faculty2 = new Faculty("Мехмат", exams, humanitarianSpeciality, educators);
            ArrayList<Faculty> faculties = new ArrayList<>();
            faculties.add(faculty);
            faculties.add(faculty2);
            University bsu = new University("БГУ", 45, "Андрей Дмитриевич Король", faculties);
            Bachelor bachelor = new Bachelor(21, "anton", 45,
                    3, EducationType.BUDGET, bsu, faculty, "gre");
            Scanner scan = new Scanner(System.in);
            System.out.println("Введите ваше имя:");
            String name = scan.next();
            bachelor.setName(name);

            System.out.println("Введите номер курса на котором вы учитесь");
            int courseNum = scan.nextInt();
            while (courseNum <= 0 || courseNum > 5){
                System.out.println("Вы ввели неверный номер курса введите еще раз");
                courseNum = scan.nextInt();
            }
            bachelor.setStudyYear(courseNum);

            System.out.println("Введите название университета на который хотите поступать:");
            String unName = scan.next();
            bsu.setTitle(unName);
            System.out.println("Информация об университете в который вы поступили: ");
            System.out.println(bsu.toString());
            System.out.println("Введите название факультета на который хотите поступать:");
            String facName = scan.next();
            faculty.setTitle(facName);
            System.out.println("Информация о факультете в который вы поступили: ");
            System.out.println(faculty.toString());

            System.out.println("Информация о вас: \n" + bachelor.toString());

            System.out.println("Стоимость экзамена для вас составит: "  + bachelor.getExamCost());
            System.out.println("Сколько денег вы хотите положить на счет");
            int cashNum = scan.nextInt();

            if (bachelor.insertCash(cashNum)){
                System.out.println("На счет успешно зачислено " + cashNum);
            }
            System.out.println("Балaнс на данный момент: " + bachelor.getCash());
            System.out.println("Вы сдаете экзамен");
            double bachelorAverage;
            while ((bachelorAverage = bachelor.passExams(2)) == 0){
                System.out.println("Вы не сдали экзамен пополните счет:");
                cashNum = scan.nextInt();
                bachelor.insertCash(cashNum);

            }

            System.out.println("Вы успешно сдали экзамен! Ваш средний балл - " + bachelorAverage);

            Graduate graduate = new Graduate(12, "rge", 45, 2,
                    EducationType.PAID, bsu, faculty2, "btr", 8);
            graduate.insertCash(150);
            double graduateAverage = graduate.passExams(10);
                System.out.println("Средняя оценка по факультету: " + faculty.getAverage());
                System.out.println("Средняя оценка по университету: " + bsu.getAverage());
                System.out.println("Информация о вашей специальности:");
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
