package com.isep.model;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Wizard extends Character {
    private String name;
    private Wand wand;
    private House house;
    private Pet pet;
    private List<Potion> potions;
    private List<AbstractSpell> knownSpells;
    private int maxHp;
    private int hp;
    private int xp;
    private int level;

    public Wizard(String name, int maxHp, Wand wand, House house) {
        this.wand = wand;
        this.name = name;
        this.maxHp = maxHp;
        this.hp = maxHp;
        this.xp = 0;
        this.level = 1;
        this.house = house;

        //this.spellPower = spellPower;
        //this.maxSpellPower = spellPower;
        this.knownSpells = new ArrayList<>();

    }

    public String getName() {
            return name;
        }

    public House getHouse(){ return house; }

    public int getMaxHp() {
            return maxHp;
        }
    public int getHp() {
        return hp;
    }
    public int getXp() {
        return xp;
    }

    public int getLevel() {
        return level;
    }

    public void castSpell(Wizard enemyWizard) {
        Random random = new Random();
        int damage = random.nextInt(-5,5); //+le sort
        enemyWizard.takeDamage(damage);

        if (damage < 0) {
            damage = 0;
        }
    }
    public void setHp(int hp) {
            this.hp = hp;
        }
    public void setHouse(House house) {
        this.house = house;
    }


    public void takeDamage(int damage) {
        hp -= damage;
        if (hp < 0) {
            hp = 0;
        }
    }

    public boolean isDead() {
        return hp == 0;
    }
    public void gainXp(int xp) {
        this.xp += xp;
        if (this.xp >= 10 + (level-1) * 3) {
            levelUp();
        }
    }
    private void levelUp() {
        level++;
        maxHp += 10;
        hp = maxHp;
        System.out.println(name + " is now level " + level + "!");
    }

    public String toString(){

        return "Hi " + getName() + ", the Sorting Hat has assigned you to "+ house.toString() +"'s house. We have also chosen the best wand for you, it is " + wand.getSize() + " inches and has a core of " + wand.getCore();
    }
}
