package com.isep.model;

public abstract class AbstractEnemy extends Character{
    private int health;

    public AbstractEnemy(int health) {
        this.health = health;
    }

    public int getHealth() {
        return health;
    }

    public void reduceHealth(int damage) {
        health -= damage;
        if (health < 0) {
            health = 0;
        }
    }
}
