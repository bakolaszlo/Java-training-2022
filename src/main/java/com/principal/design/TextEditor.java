package com.principal.design;

public class TextEditor implements App{
    @Override
    public void open(String fileName) {
        System.out.println(" Launch TextEditor using " + fileName );
    }
}
