package com.principal.model;

import com.principal.api.Person;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Student implements Person {
    private String firstName;
    private String lastName;
    private int age;
    List<Integer> marks = new ArrayList<>();

    public Student(String firstName, String lastName, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }


    final public double computeAvgMarks() {
        if(marks == null) {
            throw new NullPointerException("Marks are null.");
        }

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
    public String toString() {
        return "Student{" +
                "studentName='" + computeName() + '\'' +
                ", age=" + age +
                ", marks=" + marks +
                '}';
    }

    @Override
    public String computeName() {
        return firstName + " " + lastName;
    }

    @Override
    public int computeAge() {
        return 0;
    }
}
