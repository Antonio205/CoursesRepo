package com.solvd.university.educators;

import com.solvd.university.controller.EducatorBuilder;

public class DepartmentHead extends  Educator {
    private String departmentTitle;

    public DepartmentHead(EducatorBuilder builder) {
        super(builder);
    }

    public DepartmentHead(String name, int experience, int salary, String departmentTitle) {
        super(name, experience, salary);
        this.departmentTitle = departmentTitle;
    }

    public String getDepartmentTitle() {
        return departmentTitle;
    }

    public void setDepartmentTitle(String departmentTitle) {
        this.departmentTitle = departmentTitle;
    }
}