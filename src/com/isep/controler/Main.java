package com.isep.controler;
import com.isep.model.*;
import com.isep.view.ConsoleDisplay;
import com.isep.view.ConsoleScanner;
import java.io.InputStream;

public class Main {
    ConsoleScanner scanner;
    ConsoleDisplay display;
    public Main(InputStream is) {
        scanner = new ConsoleScanner(is);
        display = new ConsoleDisplay();
    }

    public void House(){
        SortingHat sortingHat = new SortingHat();
        House house = sortingHat.assignHouse();
        display.printText(String.format("The Sorting Hat has assigned you to %s's house ! ", house ));
    }

    public void Pet(){
        Petshop petShop = new Petshop();
        Pet pet = petShop.getPet();
        display.printText(String.format("When you enter the Petshop you have been bound to a %s ! ", pet ));
    }
    public void Wand(){
        Wand wand = new Wand();
        String core = wand.getCore();
        display.printText("Your wand measures " + wand.getSize() + " inches with a " + core + " core.");
    }


    public static void main(String[] args) {
        Main main= new Main (System.in);
        main.Pet();
        main.House();
        main.Wand();
        }
    }

