package com.isep.model;

import com.isep.view.ConsoleScanner;

import java.util.Scanner;

public class Fight {
    private Wizard wizard;
    private Ennemy ennemy;
    private boolean playerTurn;

    public Fight(Wizard wizard, Ennemy ennemy) {
        this.wizard = wizard;
        this.ennemy = ennemy;
        this.playerTurn = true;
    }
    public void start(Ennemy ennemy) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("It is a " + ennemy.getName() + " with " + ennemy.getHp() + " HP!");
        while (wizard.getHp() > 0 && ennemy.getHp() > 0) {
            if (playerTurn) {
                System.out.println("It is your turn !");
                System.out.println("1. Attack");
                System.out.println("2. Use a potion");
                int choice = scanner.nextInt();
                scanner.nextLine();
                switch (choice) {
                    case 1:

                        for (int i = 0; i < wizard.getKnownSpells().size(); i++) {
                            System.out.println((i+1) + ". " + wizard.getKnownSpells().get(i).getName());
                        }
                        int spellChoice = scanner.nextInt();
                        scanner.nextLine();
                        Spell spell = (Spell) wizard.getKnownSpells().get(spellChoice-1);
                        wizard.attackWithSpell(ennemy,spell);
                        break;
                    case 2:

                        if (wizard.getPotions().isEmpty()){
                            System.out.println("Pas de potions !");
                        }
                        else{
                            System.out.println("What potion do you want to use ?");
                            for (int i = 0; i < wizard.getPotions().size(); i++) {
                                System.out.println((i+1) + ". Potion (" + wizard.getPotions().get(i).getHealAmount() + " HP)");
                            }
                            int potionChoice = scanner.nextInt();
                            scanner.nextLine();
                            Potion potion = wizard.getPotions().get(potionChoice-1);
                            potion.use(wizard);
                            wizard.removePotion(potion);
                            System.out.println("you used a potion you now have "+wizard.getHp()+ "HP");

                        }
                        break;
                    default:
                        System.out.println("Invalid choice!");
                        break;
                }
            } else {
                System.out.println("It's the enemy's turn!");
                if (wizard.getHouse() == House.GRYFFINDOR){
                    int damage = ennemy.getDamage()-5;
                    wizard.takeDamage(damage);
                }
                else{
                    int damage = ennemy.getDamage();
                    wizard.takeDamage(damage);
                }



                System.out.println("The "+ ennemy.getName() +" has managed to attack you still have "+wizard.getHp()+"HP");
            }
            playerTurn = !playerTurn;
        }
        if (wizard.getHp() <= 0) {
            System.out.println("You have been defeated...");
            System.out.println("You will have to start over from 0 if you want to graduate.");
            System.exit(0);
        } else {
            System.out.println("You have defeated the enemy!");
            wizard.levelUp();



        }
    }



}
