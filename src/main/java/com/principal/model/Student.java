package com.principal.model;

import com.principal.api.Person;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Student implements Person {
    private String studentName;
    private int age;

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
