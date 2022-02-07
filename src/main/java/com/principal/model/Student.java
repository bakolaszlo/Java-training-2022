package com.principal.model;

import com.principal.api.Person;

public class Student implements Person {
    private String studentName;
    private int age;

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getStudentName(){
        return studentName;
    }

    public int getAge(){
        return age;
    }

    public int getComputedAge(int age){
        var ageComputed = ++age;
        var studentNameComputed = studentName + "something";
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
