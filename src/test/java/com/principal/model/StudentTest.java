package com.principal.model;

import org.junit.Ignore;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class StudentTest {
    Student student;

    @BeforeEach // runs before each test
    void setUp() {
        student = new Student("Student","Student",19);
        List<Integer> marks = new ArrayList<>(){
            {
                add(2);
                add(3);
                add(9);
                add(5);
            }
        };
        student.setMarks(marks);
    }

    @Test // defines the test method
    @DisplayName("Returns the avg of the marks.")
    void computeMarks() {
        assertEquals(4.75, student.computeAvgMarks());
    }

    @Test // defines the test method
    @DisplayName("Returns null.")
    @Disabled("disabled for the moment will be modified on a different working item")
    void computeMarksEmpty() {
        student.getMarks().clear();
        assertEquals(-1, student.computeAvgMarks());
    }

    @Test // defines the test method
    @DisplayName("Exception test.")
    void computeMarksException() {
        student.setMarks(null);
        Throwable exception = assertThrows(NullPointerException.class, () -> student.computeAvgMarks());
        assertEquals("Marks are null.", exception.getMessage());
    }

    @Test
    @DisplayName("Tests multiple assertions")
    void testNameAndMarks() {
        assertAll(
                () -> assertEquals("Student Student",student.computeName()),
                () -> assertEquals(4.75,student.computeAvgMarks())
        );
    }

    @ParameterizedTest
    @MethodSource(value = "inputStudents")
    void testMultipleValues(String[] inputStudents){
        Student student = new Student(inputStudents[0], inputStudents[1], 34);
        String expected = inputStudents[2];
        assertEquals(expected, student.computeName(), "Regular concatenation should work");
    }

    private static Stream<Arguments> inputStudents() {
        return Stream.of(
                Arguments.of((Object) new String[] {"Timi", "Draghici", "Timi Draghici"}),
                Arguments.of((Object) new String[] {"John", "Doe", "John Doe"}),
                Arguments.of((Object) new String[] {"Mike", "Hunt", "Mike Hunt"}));
    }
}
