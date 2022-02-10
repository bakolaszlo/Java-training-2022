package com.principal.XMLIO;

import com.principal.model.Student;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.util.List;

public class XMLMain {
    public static void main(String[] args) throws ParserConfigurationException, TransformerException {

        List<Student> studentList = List.of(
                new Student("Student1", "Student",25),
                new Student("Student2", "Student",32));

        //StudentIO.writeStudents("src/main/resources/students.xml", studentList);
        StudentIO.readStudents("src/main/resources/students.xml");
    }
}
