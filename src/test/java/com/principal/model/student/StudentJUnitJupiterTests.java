package com.principal.model.student;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.principal.model.Student;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class StudentJUnitJupiterTests {
    private final Student student = new Student("Student",19);

    @Test
    void computeMarks() {
        List<Integer> marks = new ArrayList<>(){
            {
                add(2);
                add(3);
                add(9);
                add(5);
            }
        };
        student.setMarks(marks);
        assertEquals(4.75, student.computeAvgMarks());
    }
}
