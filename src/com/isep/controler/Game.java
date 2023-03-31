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
    static Wizard wizard;
    public static ThreadLocalRandom randomGenrator= ThreadLocalRandom.current();

    public static void initWizard(){
        display.printText("What's your name ?");
        String name = scanner.nextLine();

        int coreIndex = randomGenrator.nextInt(Core.values().length);
        Wand wand = new Wand(Core.values()[coreIndex], randomGenrator.nextInt(  7,15));

        int n =randomGenrator.nextInt(House.values().length);
        House house = House.values()[n];

        Wizard wizard = new Wizard(name, 100, 0, wand, house);

        display.printText(wizard.toString());


        Ennemy ennemy = new Ennemy(100,30,"Troll");
        ConsoleDisplay.printText(ennemy.getName()+"   " +ennemy.getDamage()+"   "+ennemy.getHp());









    }

    /*ca marchait pas donc je l'ai fait autre part
    public static void House(Wizard wizard) {
        String name = wizard.getName();
        House house = wizard.getHouse();
        display.printText(String.format("%s is in %s's house!", name , house));

    }

     */


    public static void Pet(){
        Petshop petShop = new Petshop();
        Pet pet = petShop.getPet();
        display.printText(String.format("After wandering in hogwarts, you just had an unexpected encounter. Now you are bounded with your new pet : a %s ! ", pet ));
    }
    /*    plus besoin fait autre part
    public static void Wand(){
        Random random = new Random();
        Core core = Core.values()[random.nextInt(Core.values().length)];
        Wand wand = new Wand(core,randomGenrator.nextInt(  7,15));
        display.printText("Your wand measures " + wand.getSize() + " inches with a " + core + " core.");
    }

     */

    public static void startGame() {
        initWizard();
        Pet();

    }
}
