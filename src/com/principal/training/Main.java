package com.principal.training;

import com.principal.exception.CustomException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDateTime;

public class Main {

    public static void main(String[] args) throws CustomException {
        System.out.println("Enter something here:");
        try{
            BufferedReader bufferRead = new BufferedReader(new InputStreamReader(System.in));
            String s = bufferRead.readLine();
            System.out.println("\nYou entered : ");
            System.out.println(s);
        }
        catch (IOException e) {
            e.printStackTrace();
            throw new CustomException("Custom exception", LocalDateTime.now());
        }
    }
}
