package com.isep.model;

public class Wand {
    private int size;
    private Core core;

    public Wand(Core core, int size) {

        this.core = core;
        this.size =  size;

    }

    public int getSize() {
        return size;
    }
    public Core getCore() {
        return core;
    }
}
