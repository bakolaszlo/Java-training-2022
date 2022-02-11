package com.principal.design;

public class WordProcessor implements App{
    @Override
    public void open(String fileName) {
        System.out.println(" Launch WordProcessor using " + fileName );
    }
}
