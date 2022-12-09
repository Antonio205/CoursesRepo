package com.solvd.university.exam;

public final class Exam {

    private String title;
    private int cost;

    public Exam(String title,  int cost) {
        this.title = title;
        this.cost = cost;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }


    public int getCost() {
        return cost;
    }

    public void setcCost(int cost) {
        this.cost = cost;
    }
}
