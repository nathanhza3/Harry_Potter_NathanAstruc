package com.isep.model;

public class Ennemy extends AbstractEnemy{


    public Ennemy(int Hp, int damage, String name) {
        super(Hp, damage, name);
    }
    public Ennemy Troll() {
        return new Ennemy(100, 20, "Troll");
    }

}
