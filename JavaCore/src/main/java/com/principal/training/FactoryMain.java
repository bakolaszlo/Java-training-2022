package com.principal.training;

import com.principal.design.App;
import com.principal.design.AppFactory;

public class FactoryMain {
    public static void main(String[] args) {
        App app = AppFactory.getAppInstance(".doc");
        app.open("Sample.doc");

        App app2 = AppFactory.getAppInstance(".txt");
        app2.open("Sample.txt");
    }
}
