package com.isep.model;
import com.isep.view.ConsoleDisplay;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

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
    private int damage;
    private int pointsToAllocate;

    public Wizard(String name, int maxHp,  int damage, Wand wand, House house) {
        this.wand = wand;
        this.name = name;
        this.maxHp = maxHp;
        this.damage = damage;
        this.hp = maxHp;
        this.xp = 0;
        this.level = 1;
        this.house = house;
        this.pointsToAllocate = 0;
        this.potions = new ArrayList<>();
        this.potions.add(new Potion(1));

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
    public int getDamage() { return damage; }
    public int getPointsToAllocate() { return pointsToAllocate;}
    public void setPointsToAllocate(int pointsToAllocate) {
        this.pointsToAllocate = pointsToAllocate;
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
    public void attackWithSpell( Ennemy ennemy, Spell spell) {
        Random random = new Random();
        int chance = random.nextInt(101); // aleatoire pour accuracy
        if (chance <= spell.getAccuracy()) { // Si le pourcentage de réussite est atteint ou dépassé
            ennemy.reduceHealth(spell.getDamage()); // Réduire les points de vie de l'ennemi
            ConsoleDisplay.printText(String.format("%s a lancé le sort %s avec succès sur %s, infligeant %d points de dégâts !",
                    this.getName(), spell.getName(), ennemy.getName(), spell.getDamage()));
        } else { // Sinon, le sort échoue
            ConsoleDisplay.printText(String.format("%s a tenté de lancer le sort %s sur %s, mais il a échoué !",
                    this.getName(), spell.getName(), ennemy.getName()));
        }
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
        pointsToAllocate++;
        Scanner scanner = new Scanner(System.in);
        while (pointsToAllocate > 0) {
            System.out.println("You have " + pointsToAllocate + " points to allocate. Enter 1 to allocate to maxHp, 2 to allocate to damage: ");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    maxHp += 10;
                    pointsToAllocate--;
                    System.out.println("maxHp and hp increased by 10.");
                    break;
                case 2:
                    damage += 5;
                    pointsToAllocate--;
                    System.out.println("Damage increased by 5.");
                    break;
                default:
                    System.out.println("Invalid choice.");
                    break;
            }
        }
        hp = maxHp;
        System.out.println("Level up! You have recovered all your life points. Max HP is now " + maxHp + ", damage is now " + damage + ".");



    }

    public String toString(){

        return "Hi " + getName() + ", the Sorting Hat has assigned you to "+ house.toString() +"'s house. We have also chosen the best wand for you, it is " + wand.getSize() + " inches and has a core of " + wand.getCore();
    }
}
