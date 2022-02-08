package com.principal.XMLIO;

import com.principal.exception.CustomException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDateTime;

public class XMLMain {
    public static void main(String[] args) throws CustomException, ParserConfigurationException, TransformerException {
        StudentIO studentIO = new StudentIO("students.xml",true);
        studentIO.writeStudents();
        studentIO.readStudents();
    }
}
