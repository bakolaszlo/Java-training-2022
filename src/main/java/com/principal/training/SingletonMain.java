package com.principal.training;

import com.principal.design.Singleton;

public class SingletonMain {
    public static void main(String[] args) {
        Singleton singleton1 = Singleton.getInstance();
        Singleton singleton2 = Singleton.getInstance();
        System.out.println(singleton2 == singleton1);
    }
}
