package com.isep.model;

public abstract class AbstractSpell {
    protected String name;
    protected int damage;
    protected int manaCost;
    protected int accuracy;

    public AbstractSpell(String name, int damage, int manaCost, int accuracy) {
        this.name = name;
        this.damage = damage;
        this.manaCost = manaCost;
        this.accuracy = accuracy;
    }

    public String getName() {
        return name;
    }

    public int getDamage() {
        return damage;
    }

    public int getManaCost() {
        return manaCost;
    }
    public int getAccuracy(){
        return accuracy;
    }
}
