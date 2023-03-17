package com.isep.model;

import java.util.Random;

public class Petshop {
    public Pet getPet() {
        Random random = new Random();
        int index = random.nextInt(Pet.values().length);
        return Pet.values()[index];
    }
}
