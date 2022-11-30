package com.solvd.university.controller;


import com.solvd.university.exception.StudentException;
import com.solvd.university.faculty.Faculty;
import com.solvd.university.students.*;
import com.solvd.university.university.University;

public class StudentFactory {

    public Student getStudent(StudentTypes type, String name, int cardNumber, int studyYear, EducationType educationType,
                              University university, Faculty faculty) throws StudentException {
        Student toReturn = null;
        switch (type) {
            case GRADUATE:
                toReturn = new Graduate(name, cardNumber, studyYear,  educationType
                , university, faculty);
                break;
            case UNDERGRADUATE:
                toReturn = new Undergraduate(name, cardNumber, studyYear,  educationType
                        , university, faculty);
                break;
            case BACHELOR:
                toReturn = new Bachelor(name, cardNumber, studyYear,  educationType
                        , university, faculty);
                break;
            default:
                throw new IllegalArgumentException("Wrong student type:" + type);
        }
        return toReturn;
    }
}
