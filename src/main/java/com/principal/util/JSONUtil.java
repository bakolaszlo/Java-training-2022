package com.principal.util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class JSONUtil {

    public static JSONArray createJsonObjects() {
        JSONArray studentsJson = new JSONArray();

        JSONObject studentDetailsJson = new JSONObject();
        studentDetailsJson.put("name", "Mihai");
        studentDetailsJson.put("age", "21");

        JSONObject studentDetailsJsonLocation = new JSONObject();
        studentDetailsJsonLocation.put("city", "Brasov");
        studentDetailsJsonLocation.put("zipcode", "500501");
        studentDetailsJsonLocation.put("country", "Romania");

        studentDetailsJson.put("location", studentDetailsJsonLocation);

        JSONObject studentDetailsJson2 = new JSONObject();
        studentDetailsJson2.put("name", "John Cena");
        studentDetailsJson2.put("age", "40");

        JSONObject studentDetailsJsonLocation2 = new JSONObject();
        studentDetailsJsonLocation2.put("city", "New York");
        studentDetailsJsonLocation2.put("zipcode", "200052");
        studentDetailsJsonLocation2.put("country", "USA");

        studentDetailsJson2.put("location", studentDetailsJsonLocation2);

        studentsJson.add(studentDetailsJson);
        studentsJson.add(studentDetailsJson2);

        return studentsJson;
    }

    public static void writeJson(JSONArray studentList) throws IOException {
        try (FileWriter file = new FileWriter("src/main/resources/students.json")){
            file.write(prettyPrintJson(studentList.toString()));
            file.flush();
        }
    }
    public static void readJsonFile() throws IOException {

        var parser = new JSONParser();
        try(FileReader reader = new FileReader("src/main/resources/students.json")){
            JSONArray students = (JSONArray) parser.parse(reader);
            students.forEach(student -> {
                var studentJson = (JSONObject) student;
                System.out.print(studentJson.get("name").toString() + "\n");
            });
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public static String prettyPrintJson(String uglyJsonString){
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        JsonParser jp = new JsonParser();
        JsonElement je = jp.parse(uglyJsonString);
        return gson.toJson(je);
    }
}