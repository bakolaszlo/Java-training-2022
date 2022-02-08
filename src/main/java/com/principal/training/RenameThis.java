package com.principal.training;

import com.principal.functional.Validate;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class RenameThis {
    public static void main(String[] args) throws IOException {
        ArrayList<String> array = new ArrayList<>();
        array.add("John");
        array.add("Tim");
        array.add("Mike");
        validateArray(array, f -> array.isEmpty());
    }

    public static List validateArray(List<String> arrays, Validate rule){
        for(String array: arrays){
            if(array.contains("John")){
                arrays.remove(array);
            }
        }
        return List.of();
    }
}
