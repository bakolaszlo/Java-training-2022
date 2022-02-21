package com.principal.training;

import com.principal.design.AnimalBuilder;

import java.util.Arrays;

public class BuilderMain {
    public static void main(String[] args) {
        AnimalBuilder animalBuilder = new AnimalBuilder().Builder().setSpecies("lion").setAge(5).build();
    }
}
