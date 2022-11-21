package com.solvd.university.educators;

public class DepartmentHead extends  Educator {
    private String departmentTitle;

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
