package com.principal.training;

import java.io.IOException;

import static com.principal.util.JSONUtil.*;

public class JSONMain {
    public static void main(String[] args) throws IOException {
        var studentList = createJsonObjects();
        writeJson(studentList);
        readJsonFile();
    }
}
