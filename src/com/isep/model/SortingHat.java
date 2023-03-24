package com.isep.model;

import java.util.Random;

public class SortingHat {
    public SortingHat() {
    }
    public House assignHouse(Wizard wizard) {
        Random random = new Random();
        int index = random.nextInt(House.values().length);
        House house = House.values()[index];
        wizard.setHouse(house);
        return House.values()[index];
    }
}


