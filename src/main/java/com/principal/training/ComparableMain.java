package com.principal.training;

import com.principal.generic.Person;

import java.util.Comparator;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class ComparableMain {
    public static void main(String[] args) {
        Set<Person> set = new TreeSet<>(new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return o1.age - o2.age;
            }
        });
        set.add(new Person("name", 12));
        set.add(new Person("name2", 14));
        set.add(new Person("name3", 16));

        Iterator<Person> it = set.iterator();
        while(it.hasNext()){
            System.out.println(it.next());
        }
    }
}
