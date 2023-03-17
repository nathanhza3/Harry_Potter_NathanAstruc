package com.isep.model;

import java.util.Random;

public class Wand {
    private int size;
    private String core;

    public Wand() {
        Random random = new Random();

        int index = random.nextInt(Core.values().length);
        this.core = Core.values()[index].toString();

        int size = random.nextInt(9)+7;
        this.size = size;

    }

    public int getSize() {
        return size;
    }
    public String getCore() {
        return core;
    }
}
