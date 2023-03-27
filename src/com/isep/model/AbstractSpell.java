package com.isep.model;

public abstract class AbstractSpell {
    protected String name;
    protected int damage;
    protected int accuracy;

    public AbstractSpell(String name, int damage, int accuracy) {
        this.name = name;
        this.damage = damage;
        this.accuracy = accuracy;
    }

    public String getName() {
        return name;
    }

    public int getDamage() {
        return damage;
    }

    public int getAccuracy(){
        return accuracy;
    }

}
