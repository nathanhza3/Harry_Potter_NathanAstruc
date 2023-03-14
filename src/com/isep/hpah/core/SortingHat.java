package com.isep.hpah.core;
import java.util.List;
import java.util.Random;

public class SortingHat {

    public House assignHouse() {
        Random random = new Random();
        int index = random.nextInt(House.values().length);
        return House.values()[index];
    }

    public static void main(String[] args) {
        SortingHat sortingHat = new SortingHat();
        House house = sortingHat.assignHouse();
        System.out.println("The Sorting Hat has assigned you to house " + house + "!");
    }
}
