package com.principal.util;

import java.io.IOException;
import java.nio.file.Paths;

public class UtilsMain {
    public static void main(String[] args) throws IOException {
        String input = FilesUtil.readTextFile("src/main/resources/file.txt");

        System.out.println(input);

        FilesUtil.writeToTextFiles("src/main/resources/copy.txt",input);

        System.out.println(FilesUtil.readTextFile("src/main/resources/copy.txt"));

        FilesUtil.readTextFilesByLines("src/main/resources/file.txt");
    }
}
