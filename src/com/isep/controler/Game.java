package com.isep.controler;

import com.isep.model.*;
import com.isep.view.ConsoleDisplay;
import com.isep.view.ConsoleScanner;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class Game {

    //static ConsoleScanner scanner;

    static Scanner scanner = new Scanner(System.in);
    static ConsoleDisplay display;
    private Wizard wizard;
    public static ThreadLocalRandom randomGenrator= ThreadLocalRandom.current();

    public  void initWizard(){
        display.printText("What's your name ?");
        String name = scanner.nextLine();

        int coreIndex = randomGenrator.nextInt(Core.values().length);
        Core core = Core.values()[coreIndex];

        Wand wand = new Wand(core, randomGenrator.nextInt(  7,15));

        int n =randomGenrator.nextInt(House.values().length);
        House house = House.values()[n];

        wizard = new Wizard(name, 100, wand, house);
        wizard.setCore(core);

        display.printText(wizard.toString());
        wizard.setPet(getPet());
        System.out.println("You just met Hagrid and since he's the nicest man he gave you 3 potions ! ");
        Potion potion1 = new Potion(wizard);
        Potion potion2 = new Potion(wizard);
        Potion potion3 = new Potion(wizard);

    }

    public Pet  getPet(){
        Petshop petShop = new Petshop();
        Pet pet = petShop.getPet();
        display.printText(String.format("After wandering in hogwarts, you just had an unexpected encounter. Now you are bounded with your new pet : a %s ! ", pet ));
        return pet;
    }

    public  void Level1(){
        display.printText(String.format("You have to face the evil Troll who is in the toilets next to the Dungeon\n" ));

        Fight fight = new Fight(wizard,new Ennemy(100,10,"Troll"));
        fight.start(new Ennemy(100,10,"Troll"));

    }

    public void Level2(){
        wizard.knownSpells.add(new Spell("Accio", 30, 80));
        display.printText(String.format("\nYou have learned a new spell, the incantation of the new spell is ACCIO"));

        display.printText(String.format("\nYou have entered the chamber of secrets. "));
        if (wizard.getHouse() == House.GRYFFINDOR) {
            display.printText(String.format("As you enter the Chamber of Secrets you feel a familiar energy flowing through you.\n" +
                    "You see the sword Legendary by Godric Gryffindor.\n" +
                    "As you are from Gryffindor, you can use this sword to defeat the basilisk"));
            wizard.knownSpells.add(new Spell("Sword legendary", 50, 70));
        }
        display.printText(String.format("You must now face the basilisk !"));
        Fight fight = new Fight(wizard,new Ennemy(150,15,"Basilic"));
        fight.start(new Ennemy(150,15,"Basilic"));
    }

    public void Level3(){
        wizard.knownSpells.add(new Spell("Expecto Patronum",100,50));
        display.printText(String.format("\nAfter many courses at Hogwarts you finally master a new spell !  \nYou have learned the spell Expecto Patronum !!"));
        display.printText(String.format("\nSeveral days later, After you have walked you arrive at the lake in the Forbidden Forest"));

        display.printText(String.format("unfortunately, you come face to face with a dementor.\nI hope that luck will be on your side and that you have followed your lessons on Expecto Patronum"));

        Fight fight = new Fight(wizard,new Ennemy(200,20,"Dementor"));
        fight.start(new Ennemy(200,20,"Dementor"));
    }
    public void Level4(){
        int choice;
        display.printText(String.format("\nYou are in a dark and sinister graveyard, where Voldemort and Peter Pettigrew are lurking."));
        display.printText(String.format("You are trapped, and your only chance of survival is to find the Portkey to escape."));
        display.printText(String.format("You frantically search around you, but there is no sign of the Portkey in sight.\nYou realize you'll have to get closer to Voldemort and Pettigrew to attract the Portkey to you."));

        while (true) {
            display.printText(String.format("What do you want to do?\n"));
            display.printText(String.format("1. Take up the fight against Voldemort and Pettigrew."));
            display.printText(String.format("2. Run towards Voldemort and Pettigrew."));
            display.printText(String.format("3. Search elsewhere for the Portkey."));

            choice = scanner.nextInt();
            if (choice == 1) {
                display.printText(String.format("You chose to engage in combat against Voldemort, I'm not sure it was the wisest choice. But anyway Good luck\n"));
                Fight fight = new Fight(wizard,new Ennemy(600,99,"Voldemort and Pettigrew"));
                fight.start(new Ennemy(600,99,"Voldemort and Pettigrew"));
            } else if (choice == 2) {
                display.printText(String.format("\nYou run towards the two wizards, narrowly avoiding their spells."));
                display.printText(String.format("You get closer to the Portkey and attract it to you with an Accio!"));
                display.printText(String.format("You grab the Portkey and disappear in a flash of light."));
                break;
            } else if (choice == 3) {
                display.printText(String.format("\nYou search around you, but find no sign of the Portkey."));
                display.printText(String.format("unfortunately, looking everywhere you walk on a branch that makes a lot of noise."));
                display.printText(String.format("Because of the noise Voldemort and Pettigrew catch up to you and attack, you have no choice but to defend yourself."));
                Fight fight = new Fight(wizard,new Ennemy(600,99,"Voldemort and Pettigrew"));
                fight.start(new Ennemy(600,99,"Voldemort and Pettigrew"));
            } else {
                display.printText(String.format("Invalid choice, please try again.\n"));
            }
        }
    }
    public void Level5(){
        System.out.println(String.format("\nIt's time for the BUSE (Basic Wizarding Examinations) and Dolores Umbridge is keeping a close watch..."));
        System.out.println(String.format("Your goal is to distract her while your friends prepare the fireworks."));
        int a = 0;
        boolean b = true;
        while (b) {
            System.out.println(String.format("\nWhat do you do? "));
            System.out.println(String.format("1. Cast Slug-vomiting Charm on Umbridge in an attempt to distract her"));
            System.out.println(String.format("2. Answer an exam question"));
            System.out.println(String.format("3. Make noise to draw her attention to you"));


            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println(String.format("You cast Cast Slug-vomiting Charm on Umbridge and made everyone laugh.\nBut but you just got kicked out of hogwarts for unacceptable behavior..."));
                    System.out.println("You will have to start over from 0 if you want to graduate.");
                    System.exit(0);
                    break;
                case 2:
                    System.out.println(String.format("You answer an exam question correctly, but Umbridge is still watching everyone..."));
                    break;
                case 3:
                    System.out.println(String.format("Well done! You distracted Umbridge for a few seconds.\n"));
                    a+=1;
                    if (a==3){
                        System.out.println(String.format("PERFECT! Your friends have finished making the fireworks and give them to you discreetly."));
                        System.out.println(String.format("You then use the fireworks and create total chaos in the exam room.\nIt's party time everyone leaves the exam room. You go to the next level!"));
                        b = false;
                    }else{
                        System.out.println(String.format("But you have to do it again to have time to finish preparing the fireworks"));

                    }

                    break;
                default:
                    System.out.println(String.format("Please enter a valid choice."));
                    continue;
            }
        }
    }

    public void Level6(){
        wizard.knownSpells.add(new Spell("Sectumsempra", 150, 80));
        display.printText(String.format("\nYou have learned a new spell, the incantation of the new spell is Sectumsempra"));
        display.printText(String.format("\nThe Death Eaters are attacking Hogwarts. Are you ready to defend it?"));
        display.printText(String.format("Use Sectumsempra to attack them head-on. \n"));
        if(wizard.getHouse() == House.SLYTHERIN) {
            int choice;
            display.printText(String.format("As you are part of the Slytherin's house you can decide to betray hogwarts and join the death eaters\n"));
            display.printText(String.format("What do you want to do?\n"));
            display.printText(String.format("1. Join the death Eaters"));
            display.printText(String.format("2. Stay with Hogwarts and fight the Death Eaters"));

            choice = scanner.nextInt();
            if (choice == 1) {
                display.printText(String.format("You join the ranks of the Death Eaters!"));
                display.printText(String.format("By allying with the death eater you go directly to the next level"));
            }
            else if (choice == 2){
                Fight fight = new Fight(wizard,new Ennemy(450,25,"Death Eaters"));
                fight.start(new Ennemy(450,25,"Death Eaters"));
                display.printText(String.format("Barely after defeating the first death eater another attacks you again"));
                fight.start(new Ennemy(450,25,"Death Eaters"));
            }
        }
        else{
            Fight fight = new Fight(wizard,new Ennemy(450,25,"Death Eaters"));
            fight.start(new Ennemy(450,25,"Death Eaters"));
            display.printText(String.format("Barely after defeating the first death eater another attacks you again"));
            fight.start(new Ennemy(450,25,"Death Eaters"));
        }

    }

    public void Level7(){
        wizard.knownSpells.add(new Spell("Expelliarmus", 250, 85));
        display.printText(String.format("\nYou have learned a new spell, the incantation of the new spell is Expelliarmus"));

        display.printText(String.format("Welcome to the level of combat against Voldemort and Bellatrix Lestrange!"));
        display.printText(String.format("Attention, Voldemort and Bellatrix Lestrange are in front of you and can kill you in one shot with Avada Kedavra."));

        display.printText(String.format("Beware, if your wand and Voldemort's wand share a core, unpredictable things will happen!"));

        if (wizard.getCore() == Core.PHOENIX_FEATHER){
            display.printText(String.format("Since your wand and Voldemort's wand share the same core, something unpredictable happened !\nWhen you started your duel, your wands exploded. Because of this explosion Voldemort and Bellatrix Lestrange who was right next to it are both dead.\n And fortunately you miraculously managed to survive !!\nYou can be proud because you managed to come out of this fight alive and defeat voldemort"));
        }
        else {
            Fight fight = new Fight(wizard, new Ennemy(700, 30, "Voldemort and Bellatrix Lestrange"));
            fight.start(new Ennemy(700, 30, "Voldemort and Bellatrix Lestrange"));
        }
        display.printText(String.format("\nCongratulations you have successfully spent 7 years at Hogwarts, \nYou have obtained your diploma and can proudly display it in your room !"));

    }




    public static void startGame() {
        Game game = new Game();
        game.initWizard();
        game.Level1();
        game.Level2();
        game.Level3();
        game.Level4();
        game.Level5();
        game.Level6();
        game.Level7();


    }
}
