package com.isep.model;

import java.util.Random;

public class SortingHat {
    public SortingHat() {
    }
    public House assignHouse() {
        Random random = new Random();
        int index = random.nextInt(House.values().length);
        return House.values()[index];
    }
}

