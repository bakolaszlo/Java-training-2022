package com.principal.model;

import com.principal.api.Person;

public class Employee implements Person {
    private String employeeName;
    private int companyId;

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public void setAge(int companyId) {
        this.companyId = companyId;
    }

    public String getEmployeeName(){
        return employeeName;
    }

    public int getAge(){
        return companyId;
    }

    public int getComputedAge(int companyId){
        var ageComputed = ++companyId;
        var employeeNameComputed = employeeName + "something";
        return ageComputed;
    }

    @Override
    public String computeName() {
        return null;
    }

    @Override
    public int computeAge() {
        return 0;
    }
}
