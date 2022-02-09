package com.principal.util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

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
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            JsonParser jp = new JsonParser();
            JsonElement je = jp.parse(studentList.toString());
            String prettyJsonString = gson.toJson(je);
            file.write(prettyJsonString);
            file.flush();
        }
    }
}