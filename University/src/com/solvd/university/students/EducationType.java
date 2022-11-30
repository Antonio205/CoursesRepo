package com.solvd.university.students;

public enum EducationType {
    PAID("paid form of education"), BUDGET("budget form of education"), CORRESPONDENCE("correspondence form of education");

    private final String tittle;

    EducationType(String tittle){
        this.tittle = tittle;
    }

    public String getTittle(){ return tittle;}

    @Override
    public String toString() {
        return "You learn on " + getTittle();
    }
}
