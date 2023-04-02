package com.isep.model;
import com.isep.view.ConsoleDisplay;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Wizard extends Character {
    private String name;
    private Wand wand;
    private Core core;
    private House house;
    private Pet pet;
    private List<Potion> potions;
    public List<AbstractSpell> knownSpells;
    private int maxHp;
    private int hp;
    private int xp;
    private int level;
    private int damage;
    private int pointsToAllocate;

    public Wizard(String name, int maxHp, Wand wand, House house) {
        this.wand = wand;
        this.core = core;
        this.name = name;
        this.maxHp = maxHp;
        this.damage = damage;
        this.hp = maxHp;
        this.xp = 0;
        this.level = 1;
        this.house = house;
        this.pointsToAllocate = 0;
        this.potions = new ArrayList<>();

        //this.potions.add(new Potion());



        this.knownSpells = new ArrayList<>();
        this.knownSpells.add(new Spell("Wingardium Leviosa", 20,70));



    }

    public boolean addPotion(Potion potion){
        return this.potions.add(potion);
    }

    public boolean removePotion(Potion potion){
        return this.potions.remove(potion);
    }

    public List<Potion> getPotions() {
        return potions;
    }

    public void setPotions(List<Potion> potions) {
        this.potions = potions;
    }

    public List<AbstractSpell> getKnownSpells() {
        return knownSpells;
    }


    public void setKnownSpells(List<AbstractSpell> knownSpells) {
        this.knownSpells = knownSpells;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }

    public String getName() {
            return name;
        }

    public House getHouse(){ return house; }

    public Core getCore() {
        return core;
    }

    public void setCore(Core core) {
        this.core = core;
    }

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
    public int getDamage() { return damage; }
    public int getPointsToAllocate() { return pointsToAllocate;}
    public void setPointsToAllocate(int pointsToAllocate) {
        this.pointsToAllocate = pointsToAllocate;
    }
    public void setHp(int hp) {
            this.hp = hp;
        }
    public void setHouse(House house) {
        this.house = house;
    }
    public void attackWithSpell( Ennemy ennemy, Spell spell) {
        Random random = new Random();
        int damage = 0;
        int chance = 0;
        if (this.getHouse() == House.RAVENCLAW){
            chance = random.nextInt(101) -25; // aléatoire pour accuracy
        }
        else {
            chance = random.nextInt(101);
        }
        if (chance <= spell.getAccuracy()) {
            if (this.getHouse() == House.SLYTHERIN){
                damage =  spell.getDamage() + 9 + this.damage;

            }
            else{
                damage= spell.getDamage();
            }
            ennemy.reduceHealth(damage);
            ConsoleDisplay.printText(String.format("%s successfully cast the %s spell on %s, inflicting %s damage!",
                    this.getName(), spell.getName(), ennemy.getName(), damage));
            ConsoleDisplay.printText(String.format("the %s has %sHP left",ennemy.getName(),ennemy.getHp()));
        } else { // Sinon, le sort échoue
            ConsoleDisplay.printText(String.format("%s attempted to cast the spell %s on %s, but it failed !",
                    this.getName(), spell.getName(), ennemy.getName()));
        }
    }
    public void takeDamage(int damage) {
        this.hp -= damage;
        if (this.hp < 0) {
            this.hp = 0;
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
    public void levelUp() {
        level++;
        pointsToAllocate++;
        Scanner scanner = new Scanner(System.in);
        while (pointsToAllocate > 0) {
            System.out.println("You have " + pointsToAllocate + " points to allocate. Enter 1 to allocate to maxHp, 2 to allocate to Bonus damage: ");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    maxHp += 10;
                    pointsToAllocate--;
                    System.out.println("maxHp and hp increased by 10.");
                    break;
                case 2:
                    this.damage += 5;
                    pointsToAllocate--;
                    System.out.println("Bonus Damage increased by 5.");
                    break;
                default:
                    System.out.println("Invalid choice.");
                    break;
            }
        }
        hp = maxHp;
        System.out.println("Level up! You have recovered all your life points. Max HP is now " + maxHp + ", Bonus damage is now " + damage + ".");
    }

    public String toString(){

        return "Hi " + getName() + ", Welcome to Hogwarts <3" +
                "\nThe Sorting Hat has assigned you to "+ house.toString() +"'s house." +
                "\nWe have also chosen the best wand for you, it is " + wand.getSize() + " inches and has a core of " + wand.getCore();
    }
}
