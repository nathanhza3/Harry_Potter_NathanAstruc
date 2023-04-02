package com.isep.model;
import java.util.ArrayList;
import java.util.List;
public class Ennemy extends AbstractEnemy{


    public Ennemy(int Hp, int damage, String name) {
        super(Hp, damage, name);
    }
    public static Ennemy Troll() {
        return new Ennemy(100, 20, "Troll");
    }

    public static List<Ennemy> getEnemies() {
        List<Ennemy> enemies = new ArrayList<>();
        enemies.add(new Ennemy( 100, 15,"Troll"));
        enemies.add(new Ennemy(150, 25,"Basilic"));
        enemies.add(new Ennemy(200, 30, "Dementor"));
        enemies.add(new Ennemy( 99999, 9999,"Voldemort and Peter Pettigrew"));
        return enemies;
    }

}
