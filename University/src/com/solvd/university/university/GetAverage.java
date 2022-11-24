package com.solvd.university.university;


import com.solvd.university.exception.StudentException;

public interface GetAverage {

    double getAverage() throws StudentException;

    double getAverageExperience();
}