package com.principal.training;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class OrderMain {
    public static void main(String[] args) {
        List<Integer> integers = new ArrayList<>();
        integers.add(300);
        integers.add(100);
        integers.add(200);

        for (Integer i:integers) {
            System.out.println(i);
        }

        System.out.println("After calling sort method");

        Collections.sort(integers);

        for (Integer i:integers) {
            System.out.println(i);
        }

        Collections.reverse(integers);
    }
}
