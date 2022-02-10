package com.principal.model;

import com.principal.api.Person;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Student implements Person {
    private String studentName;
    private int age;
    List<Integer> marks = new ArrayList<>();

    public Student(String studentName, int age) {
        this.studentName = studentName;
        this.age = age;
    }

    final public double computeAvgMarks() {
        if(marks.isEmpty()){
            return -1;
        }
        double avg = 0;
        for (var mark : marks) {
            avg+=mark;
        }
        return avg/marks.size();
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
