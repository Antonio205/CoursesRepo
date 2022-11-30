package com.solvd.university.university;


import com.solvd.university.exception.StudentException;

public interface Averageable {

    double getAverage() throws StudentException;

    double getAverageExperience();
}