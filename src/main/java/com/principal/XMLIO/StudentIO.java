package com.principal.XMLIO;

import com.principal.model.Student;
import lombok.Getter;
import lombok.Setter;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

public class StudentIO {

    public static void writeStudents(final String filename, final List<Student> studentList) throws ParserConfigurationException, TransformerException {
        DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder docBuilder = docFactory.newDocumentBuilder();

        // root elements
        Document doc = docBuilder.newDocument();
        Element rootElement = doc.createElement("university");
        doc.appendChild(rootElement);

        for (var student:  studentList) {
            Element studentRoot = doc.createElement("student");
            Element studentName = doc.createElement("studentName");
            Element studentAge = doc.createElement("age");

            studentRoot.appendChild(studentName);
            studentRoot.appendChild(studentAge);
            rootElement.appendChild(studentRoot);

            studentAge.setTextContent(String.valueOf(student.getAge()));
            studentName.setTextContent(student.computeName());
        }

        // write dom document to a file
        try (FileOutputStream output =
                     new FileOutputStream(filename)) {
            writeXml(doc, output);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // write doc to output stream
    private static void writeXml(final Document doc,
                                 final OutputStream output)
            throws TransformerException {

        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();

        // pretty print XML
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");

        DOMSource source = new DOMSource(doc);
        StreamResult result = new StreamResult(output);

        transformer.transform(source, result);
    }

    public static void readStudents(final String filename) {
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        try {

            dbf.setFeature(XMLConstants.FEATURE_SECURE_PROCESSING, true);

            DocumentBuilder db = dbf.newDocumentBuilder();

            Document doc = db.parse(new File(filename));

            doc.getDocumentElement().normalize();

            System.out.println("Root Element :" + doc.getDocumentElement().getNodeName());

            NodeList list = doc.getElementsByTagName("student");

            for (int temp = 0; temp < list.getLength(); temp++) {

                Node node = list.item(temp);

                if (node.getNodeType() == Node.ELEMENT_NODE) {

                    Element element = (Element) node;

                    String studentName = element.getElementsByTagName("studentName").item(0).getTextContent();
                    var bio = element.getElementsByTagName("bio").item(0).getAttributes();
                    String age = bio.getNamedItem("age").getTextContent();
                    String place = bio.getNamedItem("place").getTextContent();
                    String id = "";

                    if(element.getElementsByTagName("id").item(0) != null) {
                        id = element.getElementsByTagName("id").item(0).getTextContent();
                    }

                    System.out.println("Student Name: " + studentName);
                    System.out.println("Student Age : " + age);
                    System.out.println("Student place : " + place);
                    System.out.println("Student Id  : " + id);
                    System.out.println();

                }
            }


        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }
    }
}
