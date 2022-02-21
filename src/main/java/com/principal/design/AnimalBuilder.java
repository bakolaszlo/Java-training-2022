package com.principal.design;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter

public class AnimalBuilder {
    private String species;
    private int age;
    private List<String> favoriteFoods;

    private AnimalBuilder(Builder builder) {
        this.species = builder.species;
        this.age = builder.age;
        this.favoriteFoods = new ArrayList<>(builder.favoriteFoods);
    }

    public static class Builder{
        private String species;
        private int age;
        private List<String> favoriteFoods;

        public Builder() {
        }

        public Builder setSpecies(String species) {
            this.species = species;
            return this;
        }

        public Builder setAge(int age) {
            this.age = age;
            return this;
        }

        public Builder setFavoriteFoods(List<String> favoriteFoods) {
            this.favoriteFoods = favoriteFoods;
            return this;
        }

        public AnimalBuilder Build(){
            return new AnimalBuilder(this);
        }
    }
}
