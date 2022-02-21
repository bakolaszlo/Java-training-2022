package com.principal.design;

import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@ToString
public class ImmutableAnimal {
    private final String species;
    private final int age;
    private final List<String> favoriteFoods;

    public ImmutableAnimal(String species, int age, List<String> favoriteFoods){
        this.species = species;
        this.age = age;
        if(favoriteFoods == null) {
            throw new RuntimeException("favoriteFoods is required");
        }
        this.favoriteFoods = new ArrayList<>(favoriteFoods);
    }

    public String getSpecies(){
        return  species;
    }

    public int getAge(){
        return age;
    }

    public int getFavoriteFoodsCount(){
        return favoriteFoods.size();
    }

    public String getFavoriteFood(int index){
        return favoriteFoods.get(index);
    }
    public List<String> getFavoriteFoods(){
        return favoriteFoods;
    }
}
