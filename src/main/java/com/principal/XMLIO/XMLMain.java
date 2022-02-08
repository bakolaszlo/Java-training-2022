package com.principal.XMLIO;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;

public class XMLMain {
    public static void main(String[] args) throws ParserConfigurationException, TransformerException {
        StudentIO studentIO = new StudentIO("src/main/resources/students.xml");
        studentIO.writeStudents();
        studentIO.readStudents();
    }
}
