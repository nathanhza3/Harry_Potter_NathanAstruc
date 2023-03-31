package com.isep.model;

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

    public void start() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("An enemy appears!");
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
                        System.out.println("What spell do you want to use ?");
                        for (int i = 0; i < wizard.getKnownSpells().size(); i++) {
                            System.out.println((i+1) + ". " + wizard.getKnownSpells().get(i).getName());
                        }
                        int spellChoice = scanner.nextInt();
                        scanner.nextLine();
                        Spell spell = wizard.getKnownSpells().get(spellChoice-1);
                        spell.cast(ennemy);
                        break;
                    case 2:
                        System.out.println("Quelle potion voulez-vous utiliser ?");
                        for (int i = 0; i < wizard.getPotions().size(); i++) {
                            System.out.println((i+1) + ". Potion (" + wizard.getPotions().get(i).getHealAmount() + " points de vie)");
                        }
                        int potionChoice = scanner.nextInt();
                        scanner.nextLine();
                        Potion potion = wizard.getPotions().get(potionChoice-1);
                        potion.use(wizard);
                        break;
                    default:
                        System.out.println("Choix invalide !");
                        break;
                }
            } else {
                System.out.println("C'est au tour de l'ennemi !");
                wizard.takeDamage(20);
                System.out.println(wizard.getHp());
            }
            playerTurn = !playerTurn;
        }
        if (wizard.getHp() <= 0) {
            System.out.println("Vous avez été vaincu...");
        } else {
            System.out.println("Vous avez vaincu l'ennemi !");
        }
    }
}
