package com.principal.training;

import com.principal.design.ImmutableAnimal;

import java.util.Arrays;
import java.util.List;

public class ImmutableMain {
    public static void main(String[] args) {
        String string  = "something";
        String substring = string.replace('s','t');
        System.out.println(substring);

        ImmutableAnimal lion = new ImmutableAnimal("Lion",13, Arrays.asList("meat", "more meat"));
        System.out.println(lion);

    }
}
