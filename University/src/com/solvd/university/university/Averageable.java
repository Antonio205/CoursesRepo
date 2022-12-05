package com.solvd.university.university;


import com.solvd.university.exception.GetAverageException;
import com.solvd.university.exception.StudentException;

public interface Averageable {

    double getAverage() throws StudentException, GetAverageException;

    double getAverageExperience();
}