package com.isep.model;

public abstract class AbstractEnemy extends Character{
    private int Hp;
    private int damage;
    private String name;
    public AbstractEnemy(int Hp,int damage,String name) {
        this.Hp = Hp;
        this.damage = damage;
        this.name = name;
    }

    public int getHp() {
        return Hp;
    }
    public int getDamage(){
        return damage;
    }

    public String getName() {
        return name;
    }


    public void reduceHealth(int damage) {
        Hp -= damage;
        if (Hp < 0) {
            Hp = 0;
        }
    }
}
