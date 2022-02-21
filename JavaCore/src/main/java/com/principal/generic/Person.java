package com.principal.generic;

public class Person implements Comparable<Person> {
    String name;
    public int age;

    public Person(String name, int age){
        this.age = age;
        this.name = name;
    }

    @Override
    public int compareTo(Person o) {
        return (this.age - o.age);
    }

    @Override
    public String toString() {
        return name;
    }
}
